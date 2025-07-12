package org.example.dataStructures.Tree

data class TreeNode<T> (
    var value: T,
    var left: TreeNode<T>?,
    var right: TreeNode<T>?,
)

data class NTreeNode<T> (
    var value: T,
    var children: List<NTreeNode<T>>,
)