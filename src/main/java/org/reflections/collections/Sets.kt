@file:JvmName("Sets")

package org.reflections.collections

fun <E> newHashSet(vararg elements: E): HashSet<E> {
  return hashSetOf(*elements)
}

fun <E> newHashSet(elements: Collection<E>): HashSet<E> {
  return HashSet(elements)
}

fun <E> newHashSet(elements: Iterable<E>): HashSet<E> {
  val set = HashSet<E>()
  for (element in elements) {
    set.add(element)
  }
  return set
}