package algorithms.grapths

import org.example.algorithms.graphs.findCycles
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindCyclesTest {

    @Test
    fun `should find cycles from a matrix graph representation`() {
        val matrix = arrayOf(
            booleanArrayOf(false, false, true),
            booleanArrayOf(true, false, false),
            booleanArrayOf(false, true, false),
        )
        val expectation = intArrayOf(0, 2, 1)
        val ans = findCycles(matrix)[0]
        for ((index, item) in expectation.withIndex()) {
            assertEquals(item, ans[index])
        }
    }

    @Test
    fun `should find cycles from a matrix graph representation V2`() {
        val matrix = arrayOf(
            booleanArrayOf(false, false, true, false, false),
            booleanArrayOf(true, false, false, false, false),
            booleanArrayOf(false, true, false, false, false),
            booleanArrayOf(false, false, false, false, true),
            booleanArrayOf(false, false, false, true, false),
        )
        val expectation = intArrayOf(3, 4)
        val ans = findCycles(matrix)
        for ((index, item) in expectation.withIndex()) {
            assertEquals(item, ans[1][index])
        }
    }
}