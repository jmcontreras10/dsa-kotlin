package algorithms.grapths

import org.example.algorithms.graphs.bfs
import org.example.algorithms.graphs.dfs
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BfsTest {
    @Test
    fun `should return empty if no graph`() {
        assertEquals(emptyList(), bfs(emptyArray()))
    }

    @Test
    fun `should return all the visited nodes`() {
        /*0 > 1 > 2 > 4
          v   ^   v
          6   |-- 3 > 5*/
        val graph = arrayOf(
            booleanArrayOf(false, true, false, false, false, false, true),
            booleanArrayOf(false, false, true, false, false, false, false),
            booleanArrayOf(false, false, false, true, true, false, false),
            booleanArrayOf(false, true, false, false, false, true, false),
            booleanArrayOf(false, false, false, false, false, false, false),
            booleanArrayOf(false, false, false, false, false, false, false),
            booleanArrayOf(false, false, false, false, false, false, false),
        )
        val expected = arrayOf(0, 1, 6, 2, 3, 4, 5)
        val ans = bfs(graph)

        for ((i, node) in expected.withIndex()) {
            assertEquals(node, ans[i])
        }
    }
}