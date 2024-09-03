package online.expotential.finite.core.spaces.builders

import online.expotential.finite.core.testing.TestingEnum
import online.expotential.finite.core.testing.TestingEnum.VALUE_ONE
import online.expotential.finite.core.testing.TestingEnum.VALUE_TWO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpaceBuildersTest {

    @Test
    fun testSpaceForClass() {
        val space = SpaceBuilders.spaceForClass(TestingEnum::class.java)
            .build()
        assertEquals("TestingEnum", space.description())
        assertEquals("Value [VALUE_ONE]", space.describeItem(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", space.describeItem(VALUE_TWO))
    }

    @Test
    fun testSpaceForClassWithOverriddenDescription() {
        val space = SpaceBuilders.spaceForClass(TestingEnum::class.java)
            .withDescription("A testing enumeration")
            .build()
        assertEquals("A testing enumeration", space.description())
        assertEquals("Value [VALUE_ONE]", space.describeItem(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", space.describeItem(VALUE_TWO))
    }

    @Test
    fun testSpaceForClassWithOverriddenItemDescriber() {
        val space = SpaceBuilders.spaceForClass(TestingEnum::class.java)
            .withItemDescriber { "It is ${it.name}" }
            .build()
        assertEquals("TestingEnum", space.description())
        assertEquals("It is VALUE_ONE", space.describeItem(VALUE_ONE))
        assertEquals("It is VALUE_TWO", space.describeItem(VALUE_TWO))
    }

    @Test
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
    fun testFiniteSpaceForEnumClass() {
        val space = SpaceBuilders.finiteSpaceForEnumClass(TestingEnum::class.java)
            .build()
        assertEquals("TestingEnum", space.description())
        assertEquals("Value [VALUE_ONE]", space.describeItem(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", space.describeItem(VALUE_TWO))
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), space.items())
    }

    @Test
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
