package online.expotential.finite.scala.testing

case class TestingDomain(camelCase: String)

object TestingDomain {
  object DOG extends TestingDomain("Dog")
  object PARROT extends TestingDomain("Parrot")
}
