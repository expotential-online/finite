package online.expotential.finite.core.spaces

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class StandardFiniteSpaceTest {

    @Test
    fun testDescription() {
        val space = StandardFiniteSpace(Int::class.java, "Hello world", setOf()) { "" }
        assertEquals("Hello world", space.description())
    }

    @Test
    fun testDescribeItem() {
        val space = StandardFiniteSpace(Int::class.java, "Hello world", setOf()) { "Number $it" }
        assertEquals("Number 5", space.describeItem(5))
    }

    @Test
    fun testItems() {
        val items = setOf(3, 7)
        val space = StandardFiniteSpace(Int::class.java, "Hello world", items) { "Number $it" }
        assertSame(items, space.items())
    }

    @Test
    fun testToString() {
        val space = StandardFiniteSpace(Int::class.java, "Hello world", setOf(1, 5)) { "Number $it" }
        assertEquals("Space [Hello world] containing items [1, 5]", space.toString())
    }
}
