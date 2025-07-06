package dataStructures

import org.example.dataStructures.list.LinkedList
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LinkedListTest {
    private var list = LinkedList<Int>()
    private val elements = arrayOf(1,0,4,4,6,8,1,1,98)

    @BeforeEach
    fun setup() {
        list = LinkedList<Int>()
        for (elem in elements) {
            list.add(elem)
        }
    }

    @Test
    fun `should add elements to the list`() {
        val addList = LinkedList<Int>()

        assertEquals(addList.size, 0)
        for ((index, value) in elements.withIndex()) {
            addList.add(value)
            assertEquals(addList.size, index + 1)
            assertEquals(addList.get(addList.size-1), value)
        }
    }

    @Nested
    inner class GetAndFindTest {
        @Test
        fun `should get null when no elements found`(){
            val getList = LinkedList<Int>()
            assertNull(getList.get(2))
            assertNull(getList.find { it == 3 })

            getList.add(3)
            assertNull(getList.get(1))
            assertNull(getList.find { it == 2 })
        }

        @Test
        fun `should get right elements`() {
            val list = LinkedList<Int>()
            val elements = arrayOf(0,4,4,6,8,1,98)
            for (elem in elements) {
                list.add(elem)
            }

            for ((index, elem) in elements.withIndex()) {
                assertEquals(list.get(index), elem)
                assertEquals(list.find { it == elem }, elem)
            }
        }
    }

    @Nested
    inner class RemoveTest {
        @Test
        fun `should return null or 0 when no removed`() {
            val removeList = LinkedList<Int>()
            var removed = removeList.removeFirstThat { it == 0 }
            assertNull(removed)
            assertEquals(0, removeList.size)

            var removalCounter = removeList.removeAllThat { it == 4 }
            assertEquals(0, removalCounter)
            assertEquals(0, removeList.size)

            removeList.add(3)

            removed = removeList.removeFirstThat { it == 0 }
            assertNull(removed)
            assertEquals(1, removeList.size)

            removalCounter = removeList.removeAllThat { it == 4 }
            assertEquals(0, removalCounter)
            assertEquals(1, removeList.size)
        }

        @Test
        fun `should remove right objects`(){
            val removed = list.removeFirstThat { it == 4 }
            var newElements = arrayOf(1,0,4,6,8,1,1,98)
            list.forEachIndexed { index, value ->
                assertEquals(newElements[index], value)
            }
            assertEquals(4, removed)
            assertEquals(newElements.size, list.size)

            val removedQuantity = list.removeAllThat { it == 1 }
            newElements = arrayOf(0,4,6,8,98)
            list.forEachIndexed { index, value ->
                assertEquals(newElements[index], value)
            }
            assertEquals(3, removedQuantity)
            assertEquals(newElements.size, list.size)
        }
    }
}