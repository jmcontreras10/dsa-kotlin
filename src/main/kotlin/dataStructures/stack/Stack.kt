package org.example.dataStructures.stack

import org.example.dataStructures.list.ListNode

class Stack<T>: IStack<T> {
    private var head: ListNode<T>? = null
    var size: Int = 0

    override fun push(item: T) {
        head = ListNode(item, head)
        size++
    }

    override fun pop(): T? {
        if (size == 0) return null
        val item = head?.value
        head = head?.next
        size--
        return item
    }

    override fun peek(): T? {
        if (size == 0) return null
        return head?.value
    }
}