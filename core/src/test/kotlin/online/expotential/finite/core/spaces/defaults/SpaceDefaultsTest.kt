package online.expotential.finite.core.spaces.defaults

import online.expotential.finite.core.testing.TestingEnum
import online.expotential.finite.core.testing.TestingEnum.VALUE_ONE
import online.expotential.finite.core.testing.TestingEnum.VALUE_TWO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("The space defaults helper")
class SpaceDefaultsTest {

    @Test
    @DisplayName("should produce the expected default space description")
    fun testDefaultSpaceDescription() {
        assertEquals("TestingEnum", SpaceDefaults.defaultSpaceDescription(TestingEnum::class.java))
    }

    @Test
    @DisplayName("should dispense the expected way to describe items")
    fun testDefaultItemDescriber() {
        assertEquals("Value [VALUE_ONE]", SpaceDefaults.defaultItemDescriber<TestingEnum>().invoke(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", SpaceDefaults.defaultItemDescriber<TestingEnum>().invoke(VALUE_TWO))
    }

    @Test
    @DisplayName("should extract the all enumerated values as items given an enum")
    fun testDefaultItems() {
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), SpaceDefaults.defaultItems(TestingEnum::class.java))
    }
}
