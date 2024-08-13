package online.expotential.finite.core.spaces.defaults

import online.expotential.finite.core.spaces.defaults.SpaceDefaultsTest.TestingSpace.VALUE_ONE
import online.expotential.finite.core.spaces.defaults.SpaceDefaultsTest.TestingSpace.VALUE_TWO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpaceDefaultsTest {

    @Test
    fun testDefaultSpaceDescription() {
        assertEquals("TestingSpace", SpaceDefaults.defaultSpaceDescription(TestingSpace::class.java))
    }

    @Test
    fun testDefaultItemDescriber() {
        assertEquals("Value [VALUE_ONE]", SpaceDefaults.defaultItemDescriber<TestingSpace>().invoke(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", SpaceDefaults.defaultItemDescriber<TestingSpace>().invoke(VALUE_TWO))
    }

    @Test
    fun testDefaultItem() {
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), SpaceDefaults.defaultItems(TestingSpace::class.java))
    }

    enum class TestingSpace {
        VALUE_ONE,
        VALUE_TWO;

        override fun toString(): String = "Value [$name]"
    }
}
