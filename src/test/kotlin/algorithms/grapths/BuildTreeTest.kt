package algorithms.grapths

import org.example.algorithms.graphs.buildTree
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BuildTreeTest {
    @Test
    fun `should build a tree with the given paths`() {
        val input = arrayOf(
            "1-3-5-7-9",
            "3-4-6",
            "3-8-10",
            "5-11-13",
            "5-15-16",
        )
        val root = buildTree(input)
        assertEquals(root.value, 1)
    }
}