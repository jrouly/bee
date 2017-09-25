package direct.bees.service

import direct.bees.models.Bee

trait BeeService {

  def bee: Bee

  def moreBees: Stream[Bee]

  def nBees(n: Int): Stream[Bee]

}
