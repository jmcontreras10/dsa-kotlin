package org.example.algorithms.graphs

fun findCycles(tasksDependencies: Array<BooleanArray>): Array<IntArray> {
    val visited = mutableSetOf<Int>()
    val ans = mutableListOf<IntArray>()

    fun findCycle(
        current: Int,
        currAns: MutableList<Int>
    ): Boolean {
        if (visited.contains(current))
            return ans.add(currAns.toIntArray())
        currAns.add(current)
        visited.add(current)
        for ((childIndex, childTaskDependency) in tasksDependencies[current].withIndex())
            if (childTaskDependency) findCycle(childIndex, currAns)
        currAns.removeLast()
        return true
    }

    for (index in tasksDependencies.indices) {
        val currAns = mutableListOf<Int>()
        if (!visited.contains(index)) findCycle(index, currAns)
    }
    return ans.toTypedArray()
}
