package online.expotential.finite.scala.spaces.builders

import online.expotential.finite.scala.testing.TestingDomain
import online.expotential.finite.scala.testing.TestingDomain._
import org.junit.jupiter.api.Assertions.{assertEquals, assertIterableEquals}
import org.junit.jupiter.api.{DisplayName, Test}

import scala.jdk.CollectionConverters.IterableHasAsJava

@DisplayName("A Scala space builder")
class ScalaSpaceBuildersTest {

  @Test
  @DisplayName("should create a space with default behaviour")
  def testObjectOfObjectsSpaceForClass(): Unit = {
    val space = ScalaSpaceBuilders.spaceForObjectOfObjects(classOf[TestingDomain])
      .build()
    assertEquals(classOf[TestingDomain], space.spaceClass())
    assertEquals("TestingDomain", space.description())
    assertEquals("TestingDomain(Dog)", space.describeItem(DOG))
    assertEquals("TestingDomain(Parrot)", space.describeItem(PARROT))
    assertIterableEquals(Set(DOG, PARROT).asJava, space.items())
  }

  @Test
  @DisplayName("should create a space with an overridden description")
  def testObjectOfObjectsSpaceForClassWithOverriddenDescription(): Unit = {
    val space = ScalaSpaceBuilders.spaceForObjectOfObjects(classOf[TestingDomain])
      .withDescription("Animals")
      .build()
    assertEquals(classOf[TestingDomain], space.spaceClass())
    assertEquals("Animals", space.description())
    assertEquals("TestingDomain(Dog)", space.describeItem(DOG))
    assertEquals("TestingDomain(Parrot)", space.describeItem(PARROT))
    assertIterableEquals(Set(DOG, PARROT).asJava, space.items())
  }

  @Test
  @DisplayName("should create a space with an overridden item describer")
  def testObjectOfObjectsSpaceForClassWithOverriddenItemDescriber(): Unit = {
    val space = ScalaSpaceBuilders.spaceForObjectOfObjects(classOf[TestingDomain])
      .withItemDescriber("It is a " + _.camelCase)
      .build()
    assertEquals(classOf[TestingDomain], space.spaceClass())
    assertEquals("TestingDomain", space.description())
    assertEquals("It is a Dog", space.describeItem(DOG))
    assertEquals("It is a Parrot", space.describeItem(PARROT))
    assertIterableEquals(Set(DOG, PARROT).asJava, space.items())
  }

  @Test
  @DisplayName("should create a space with an overridden description and item describer")
  def testObjectOfObjectsSpaceForClassWithOverriddenDescriptionAndItemDescriber(): Unit = {
    val space = ScalaSpaceBuilders.spaceForObjectOfObjects(classOf[TestingDomain])
      .withDescription("Animals")
      .withItemDescriber("It is a " + _.camelCase)
      .build()
    assertEquals(classOf[TestingDomain], space.spaceClass())
    assertEquals("Animals", space.description())
    assertEquals("It is a Dog", space.describeItem(DOG))
    assertEquals("It is a Parrot", space.describeItem(PARROT))
    assertIterableEquals(Set(DOG, PARROT).asJava, space.items())
  }
}
