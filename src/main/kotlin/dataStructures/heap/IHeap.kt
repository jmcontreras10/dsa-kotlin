package org.example.dataStructures.heap

interface IHeap<T> {
    /**
     * Add an element to the heap, keeping the desired order
     */
    fun add(element: T): Unit

    /**
     * See the top element (min, max, custom)
     */
    fun top(): T?

    /**
     * Get the top element (min, max, custom) by removing it
     */
    fun getTop(): T?
}