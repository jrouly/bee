package direct.bees.service

import direct.bees.model.Bee

class StandardBeeService extends BeeService {

  override lazy val bee: Bee = Bee.standard

  override def moreBees: Stream[Bee] = Stream.continually(bee)

  override def nBees(n: Int): Stream[Bee] = moreBees.take(n)

}
