@file:JvmName("CollectionUtils")
package rcdavis.nycschools.util

/**
 * Takes two different type lists and zips them into one if they pass a predicate check.
 */
fun <T1, T2, R> List<T1>.zip(
    l: List<T2>,
    predicate: (T1, T2) -> Boolean,
    transform: (T1, T2) -> R
): List<R> {
    val results = mutableListOf<R>()
    forEach { first ->
        l.forEach { second ->
            if (predicate(first, second))
                results.add(transform(first, second))
        }
    }
    return results
}
