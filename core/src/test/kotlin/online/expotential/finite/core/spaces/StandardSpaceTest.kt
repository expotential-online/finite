package online.expotential.finite.core.spaces

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("A standard space")
class StandardSpaceTest {

    @Test
    @DisplayName("should return the class of its items")
    fun testSpaceClass() {
        val space = StandardSpace(Int::class.java, "Hello world") { "" }
        assertEquals(Int::class.java, space.spaceClass())
    }

    @Test
    @DisplayName("should describe an item in the expected way")
    fun testDescription() {
        val space = StandardSpace(Int::class.java, "Hello world") { "" }
        assertEquals("Hello world", space.description())
    }

    @Test
    @DisplayName("should return all items contained in the space")
    fun testDescribeItem() {
        val space = StandardSpace(Int::class.java, "Hello world") { "Number $it" }
        assertEquals("Number 5", space.describeItem(5))
    }

    @Test
    @DisplayName("should have a meaningful string representation")
    fun testToString() {
        val space = StandardSpace(Int::class.java, "Hello world") { "Number $it" }
        assertEquals("Space [Hello world]", space.toString())
    }
}
