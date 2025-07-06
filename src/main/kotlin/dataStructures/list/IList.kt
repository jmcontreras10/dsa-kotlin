package org.example.dataStructures.list

interface IList<T>: Iterable<T> {
    /**
     * Add a new element to the list (start)
     */
    fun add(item: T): Unit

    /**
     * Remove the first element that match the condition
     * @return removed item
     */
    fun removeFirstThat(matcher: (item: T?) -> Boolean): T?

    /**
     * Remove all elements in the list that match the condition
     * @return the number of removed items
     */
    fun removeAllThat(matcher: (item: T?) -> Boolean): Int

    /**
     * Get the element in the selected index, null if out of bounds
     */
    fun get(index: Int): T?

    /**
     * Get the first element that matches the condition, null if not found
     */
    fun find(matcher: (T?) -> Boolean): T?
}