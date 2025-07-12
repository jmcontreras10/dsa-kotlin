package algorithms.grapths

import org.example.algorithms.binarySearch.binarySearch
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinarySearchTest {
    @Test
    fun `Should find the right element`() {
        //                [ 0 1 2 3 4 5 6  7   8   9 ] -> 10
        val array = arrayOf(1,2,3,4,7,8,14,17,189,504)

        var resultIndex = binarySearch(array, 3)
        assertEquals(2, resultIndex)

        resultIndex = binarySearch(array, 504)
        assertEquals(array.size - 1, resultIndex)
    }

    @Test
    fun `Should return -1 if not found`() {
        //                [ 0 1 2 3 4 5 6  7   8   9 ] -> 10
        val array = arrayOf(1,2,3,4,7,8,14,17,189,504)

        var resultIndex = binarySearch(array, 600)
        assertEquals(-1, resultIndex)

        resultIndex = binarySearch(array, 0)
        assertEquals(-1, resultIndex)

        resultIndex = binarySearch(array, 15)
        assertEquals(-1, resultIndex)
    }
}