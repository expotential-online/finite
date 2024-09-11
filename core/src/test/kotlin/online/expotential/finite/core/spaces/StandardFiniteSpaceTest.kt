package online.expotential.finite.core.spaces

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("A standard finite space")
class StandardFiniteSpaceTest {

    @Test
    @DisplayName("should give the expected description")
    fun testDescription() {
        val space = StandardFiniteSpace(Int::class.java, "Hello world", setOf()) { "" }
        assertEquals("Hello world", space.description())
    }

    @Test
    @DisplayName("should describe an item in the expected way")
    fun testDescribeItem() {
        val space = StandardFiniteSpace(Int::class.java, "Hello world", setOf()) { "Number $it" }
        assertEquals("Number 5", space.describeItem(5))
    }

    @Test
    @DisplayName("should return all items contained in the space")
    fun testItems() {
        val items = setOf(3, 7)
        val space = StandardFiniteSpace(Int::class.java, "Hello world", items) { "Number $it" }
        assertSame(items, space.items())
    }

    @Test
    @DisplayName("should have a meaningful string representation")
    fun testToString() {
        val space = StandardFiniteSpace(Int::class.java, "Hello world", setOf(1, 5)) { "Number $it" }
        assertEquals("Space [Hello world] containing items [1, 5]", space.toString())
    }
}
