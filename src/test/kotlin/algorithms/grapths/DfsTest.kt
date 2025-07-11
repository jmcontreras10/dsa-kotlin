package algorithms.grapths

import org.example.algorithms.graphs.dfs
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DfsTest {
    @Test
    fun `should return empty if no graph`() {
        assertEquals(emptyList(), dfs(emptyArray()))
    }

    @Test
    fun `should return all the visited nodes`() {
        /*0 > 1 > 2 > 4
              ^   v
              |-- 3 > 5*/
        val graph = arrayOf(
            booleanArrayOf(false, true, false, false, false, false),
            booleanArrayOf(false, false, true, false, false, false),
            booleanArrayOf(false, false, false, true, true, false),
            booleanArrayOf(false, true, false, false, false, true),
            booleanArrayOf(false, false, false, false, false, false),
            booleanArrayOf(false, false, false, false, false, false),
        )
        val expected = arrayOf(0, 1, 2, 3, 5, 4)
        val ans = dfs(graph)

        for ((i, node) in expected.withIndex()) {
            assertEquals(node, ans[i])
        }
    }
}


