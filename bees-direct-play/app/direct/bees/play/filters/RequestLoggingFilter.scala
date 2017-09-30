package direct.bees.play.filters

import akka.stream.Materializer
import RequestLoggingFilter.LoggableRequestResponse
import play.api.Logger
import play.api.libs.json.{Format, Json}
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class RequestLoggingFilter(
  implicit
  val mat: Materializer,
  ec: ExecutionContext
) extends Filter {
  override def apply(next: RequestHeader => Future[Result])(request: RequestHeader): Future[Result] = {
    val resultFuture = next(request)
    val start = System.currentTimeMillis()
    resultFuture.map { result =>
      val duration = System.currentTimeMillis() - start
      val logObject = LoggableRequestResponse(request, result, duration)
      Logger.info(Json.toJson(logObject).toString)
      result
    }
  }
}

object RequestLoggingFilter {

  case class LoggableRequestResponse(
    duration: Long,
    method: String,
    remoteAddr: String,
    status: Int,
    uri: String,
    contentLength: Option[Long]
  )

  object LoggableRequestResponse {
    def apply(request: RequestHeader, result: Result, duration: Long): LoggableRequestResponse = {
      LoggableRequestResponse(
        duration = duration,
        method = request.method,
        remoteAddr = request.remoteAddress,
        status = result.header.status,
        uri = request.uri,
        contentLength = result.body.contentLength
      )
    }
  }

  implicit val loggableRequestResponseFormat: Format[LoggableRequestResponse] = Json.format[LoggableRequestResponse]

}
