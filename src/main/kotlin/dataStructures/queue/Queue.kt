package org.example.dataStructures.queue

import org.example.dataStructures.list.ListNode

class Queue<T>: IQueue<T> {
    private var head: ListNode<T>? = null
    private var tail: ListNode<T>? = null
    var size = 0

    override fun enqueue(item: T) {
        if (tail == null) {
            head = ListNode(item)
            tail = head
            size++
            return
        }
        tail!!.next = ListNode(item)
        tail = tail!!.next
        size++
    }

    override fun dequeue(): T? {
        if (head == null) return null
        val curr = head!!.value
        head = head!!.next
        if (head == null) tail = null
        size--
        return curr
    }

    override fun peek(): T? {
        if (head == null) return null
        return head!!.value
    }
}