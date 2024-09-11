package online.expotential.finite.core.spaces.builders

import online.expotential.finite.core.testing.TestingEnum
import online.expotential.finite.core.testing.TestingEnum.VALUE_ONE
import online.expotential.finite.core.testing.TestingEnum.VALUE_TWO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("The space builders factory")
class SpaceBuildersTest {

    @Test
    @DisplayName("should build a space from just the class of its items")
    fun testSpaceForClass() {
        val space = SpaceBuilders.spaceForClass(TestingEnum::class.java)
            .build()
        assertEquals("TestingEnum", space.description())
        assertEquals("Value [VALUE_ONE]", space.describeItem(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", space.describeItem(VALUE_TWO))
    }

    @Test
    @DisplayName("should build a space from the class of its items and a space description")
    fun testSpaceForClassWithOverriddenDescription() {
        val space = SpaceBuilders.spaceForClass(TestingEnum::class.java)
            .withDescription("A testing enumeration")
            .build()
        assertEquals("A testing enumeration", space.description())
        assertEquals("Value [VALUE_ONE]", space.describeItem(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", space.describeItem(VALUE_TWO))
    }

    @Test
    @DisplayName("should build a space from the class of its items and a way to describe those items")
    fun testSpaceForClassWithOverriddenItemDescriber() {
        val space = SpaceBuilders.spaceForClass(TestingEnum::class.java)
            .withItemDescriber { "It is ${it.name}" }
            .build()
        assertEquals("TestingEnum", space.description())
        assertEquals("It is VALUE_ONE", space.describeItem(VALUE_ONE))
        assertEquals("It is VALUE_TWO", space.describeItem(VALUE_TWO))
    }

    @Test
    @DisplayName("should build a space from the class of its items, a space description and a way to describe its items")
    fun testSpaceForClassWithOverriddenDescriptionAndItemDescriber() {
        val space = SpaceBuilders.spaceForClass(TestingEnum::class.java)
            .withDescription("A testing enumeration")
            .withItemDescriber { "It is ${it.name}" }
            .build()
        assertEquals("A testing enumeration", space.description())
        assertEquals("It is VALUE_ONE", space.describeItem(VALUE_ONE))
        assertEquals("It is VALUE_TWO", space.describeItem(VALUE_TWO))
    }

    @Test
    @DisplayName("should build a finite space from the items of an enum class")
    fun testFiniteSpaceForEnumClass() {
        val space = SpaceBuilders.finiteSpaceForEnumClass(TestingEnum::class.java)
            .build()
        assertEquals("TestingEnum", space.description())
        assertEquals("Value [VALUE_ONE]", space.describeItem(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", space.describeItem(VALUE_TWO))
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), space.items())
    }

    @Test
    @DisplayName("should build a finite space from the items of an enum class and a space description")
    fun testFiniteSpaceForEnumClassWithOverriddenDescription() {
        val space = SpaceBuilders.finiteSpaceForEnumClass(TestingEnum::class.java)
            .withDescription("A testing enumeration")
            .build()
        assertEquals("A testing enumeration", space.description())
        assertEquals("Value [VALUE_ONE]", space.describeItem(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", space.describeItem(VALUE_TWO))
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), space.items())
    }

    @Test
    @DisplayName("should build a finite space from the items of an enum class and a way to describe those items")
    fun testFiniteSpaceForEnumClassWithOverriddenItemDescriber() {
        val space = SpaceBuilders.finiteSpaceForEnumClass(TestingEnum::class.java)
            .withItemDescriber { "It is ${it.name}" }
            .build()
        assertEquals("TestingEnum", space.description())
        assertEquals("It is VALUE_ONE", space.describeItem(VALUE_ONE))
        assertEquals("It is VALUE_TWO", space.describeItem(VALUE_TWO))
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), space.items())
    }

    @Test
    @DisplayName("should build a finite space from the items of an enum class, a space description and a way to describe its items")
    fun testFiniteSpaceForEnumClassWithOverriddenDescriptionAndItemDescriber() {
        val space = SpaceBuilders.finiteSpaceForEnumClass(TestingEnum::class.java)
            .withDescription("A testing enumeration")
            .withItemDescriber { "It is ${it.name}" }
            .build()
        assertEquals("A testing enumeration", space.description())
        assertEquals("It is VALUE_ONE", space.describeItem(VALUE_ONE))
        assertEquals("It is VALUE_TWO", space.describeItem(VALUE_TWO))
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), space.items())
    }
}
