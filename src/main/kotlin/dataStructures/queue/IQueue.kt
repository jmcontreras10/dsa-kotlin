package org.example.dataStructures.queue

interface IQueue<T> {
    /**
     * Should enqueue a new element
     */
    fun enqueue(item: T): Unit

    /**
     * Should dequeue the older element, null if empty
     */
    fun dequeue(): T?

    /**
     * Should see the older element, null if empty
     */
    fun peek(): T?
}