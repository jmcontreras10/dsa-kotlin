package dataStructures

import org.example.dataStructures.heap.Heap
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HeapTest {

    @Test
    fun `should add elements to the max heap`() {
        val elements = intArrayOf(8,1,6,2,5,3,0)
        val heap = Heap<Int> {
            a, b -> when {
                a > b -> -1
                else -> 1
            }
        }

        for ((index, elem) in elements.withIndex()) {
            heap.add(elem)
            assertEquals(index + 1, heap.size)
            assertEquals(8, heap.top())
        }
    }

    @Test
    fun `should always return the biggest`() {
        val elements = intArrayOf(8,5,2,1,3,6)
        val toRemove = intArrayOf(8,6,5,3,2,1)
        val heap = Heap<Int> {
            a, b -> when {
                a > b -> -1
                else -> 1
            }
        }
        
        for (elem in elements) {
            heap.add(elem)
        }

        for ((index, item) in toRemove.withIndex()) {
            assertEquals(toRemove.size - index, heap.size)
            val removed = heap.getTop()
            assertEquals(item, removed)
        }
    }

    @Test
    fun `should always return the smallest`() {
        val elements = intArrayOf(8,5,2,1,3,6)
        val toRemove = intArrayOf(1,2,3,5,6,8)
        val heap = Heap<Int> {
            a, b -> when {
                a < b -> -1
                else -> 1
            }
        }

        for (elem in elements) {
            heap.add(elem)
        }

        for ((index, item) in toRemove.withIndex()) {
            assertEquals(toRemove.size - index, heap.size)
            val removed = heap.getTop()
            assertEquals(item, removed)
        }
    }


    @Test
    fun `should always return null on empty`() {
        val heap = Heap<Int> {
            a, b -> when {
                a < b -> -1
                else -> 1
            }
        }

        assertEquals(0, heap.size)
        assertNull(heap.getTop())
        assertNull(heap.top())
    }

}