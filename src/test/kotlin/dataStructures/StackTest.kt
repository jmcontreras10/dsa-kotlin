package dataStructures

import org.example.dataStructures.stack.Stack
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class StackTest {
    @Test
    fun `should see null to the top of the stack`(){
        val stack = Stack<Int>()
        assertNull(stack.peek())
    }

    @Test
    fun `should add to the top of the stack`(){
        val stack = Stack<Int>()
        stack.push(2)
        stack.push(3)
        stack.push(4)
        assertEquals(4, stack.peek())
        assertEquals(3, stack.size)
    }

    @Test
    fun `should remove from the top of the stack`(){
        val stack = Stack<Int>()
        stack.push(2)
        stack.push(3)
        stack.push(4)
        assertEquals(4, stack.pop())
        assertEquals(3, stack.pop())
        assertEquals(1, stack.size)
    }

}