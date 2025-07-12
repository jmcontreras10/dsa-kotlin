package org.example.algorithms.graphs

import org.example.dataStructures.Tree.NTreeNode

fun buildTree(paths: Array<String>): NTreeNode<Int> {
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (str in paths) {
        val path = str.split("-")
        //  0   1   2   3  //4
        // [2 > 3 > 5 > 6]
        for (i in 0 until path.size - 1){
            val curr = map.getOrDefault(path[i].toInt(), mutableListOf())
            curr.add(path[i+1].toInt())
            map.put(path[i].toInt(), curr)
        }
    }
    val min = map.keys.sorted()[0]

    fun backTrack(current: Int): NTreeNode<Int> {
        val childrenItems: List<Int> =
            map.getOrDefault(current, emptyList<Int>())
        val children: List<NTreeNode<Int>> = childrenItems.map {
                backTrack(it)
        }
        return NTreeNode(current, children)
    }
    return backTrack(min)

}