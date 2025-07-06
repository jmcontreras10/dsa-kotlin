package dataStructures

import org.example.dataStructures.queue.Queue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class QueueTest {

    @Test
    fun `should see null as the oldest element`() {
        val queue = Queue<Int>()
        assertNull(queue.peek())
    }

    @Test
    fun `should enqueue and dequeue the right elements`() {
        val queue = Queue<Int>()
        for (i in 0 until 10) {
            queue.enqueue(i)
            assertEquals(i + 1, queue.size)
        }
        assertEquals(0, queue.peek())

        for (i in 0 until 10) {
            assertEquals(i, queue.dequeue())
            assertEquals(9 - i, queue.size)
        }
        assertEquals(0, queue.size)
    }
}