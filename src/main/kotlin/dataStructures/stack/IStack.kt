package org.example.dataStructures.stack

interface IStack<T> {
    /**
     * Add an element to the top of the stack
     */
    fun push(item: T): Unit

    /**
     * Get the element from the top of the stack
     */
    fun pop(): T?

    /**
     * See the element from the top of the stack
     */
    fun peek(): T?
}