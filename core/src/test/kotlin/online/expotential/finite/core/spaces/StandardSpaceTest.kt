package online.expotential.finite.core.spaces

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StandardSpaceTest {

    @Test
    fun testDescription() {
        val space = StandardSpace(Int::class.java, "Hello world") { "" }
        assertEquals("Hello world", space.description())
    }

    @Test
    fun testDescribeItem() {
        val space = StandardSpace(Int::class.java, "Hello world") { "Number $it" }
        assertEquals("Number 5", space.describeItem(5))
    }

    @Test
    fun testToString() {
        val space = StandardSpace(Int::class.java, "Hello world") { "Number $it" }
        assertEquals("Space [Hello world]", space.toString())
    }
}
