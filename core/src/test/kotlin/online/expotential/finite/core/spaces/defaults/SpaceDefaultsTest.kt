package online.expotential.finite.core.spaces.defaults

import online.expotential.finite.core.testing.TestingEnum
import online.expotential.finite.core.testing.TestingEnum.VALUE_ONE
import online.expotential.finite.core.testing.TestingEnum.VALUE_TWO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpaceDefaultsTest {

    @Test
    fun testDefaultSpaceDescription() {
        assertEquals("TestingEnum", SpaceDefaults.defaultSpaceDescription(TestingEnum::class.java))
    }

    @Test
    fun testDefaultItemDescriber() {
        assertEquals("Value [VALUE_ONE]", SpaceDefaults.defaultItemDescriber<TestingEnum>().invoke(VALUE_ONE))
        assertEquals("Value [VALUE_TWO]", SpaceDefaults.defaultItemDescriber<TestingEnum>().invoke(VALUE_TWO))
    }

    @Test
    fun testDefaultItem() {
        assertEquals(setOf(VALUE_ONE, VALUE_TWO), SpaceDefaults.defaultItems(TestingEnum::class.java))
    }
}
