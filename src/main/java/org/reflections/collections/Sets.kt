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

fun <E> difference(s0: Set<E>, s1: Set<E>): Set<E> = s0.minus(s1)