package direct.bees

import java.io.OutputStream

import direct.bees.model.Bee

package object lambda {
  implicit class BeeStream(outputStream: OutputStream) {
    def write(bee: Bee): Unit = bee.buzz.getBytes.foreach(outputStream.write(_))
  }
}
