package org.example.dataStructures.list

data class ListNode<T>(
    var value: T,
    var next: ListNode<T>? = null
)