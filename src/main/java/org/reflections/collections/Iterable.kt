@file:JvmName("Iterables")

package org.reflections.collections

import java.util.function.Predicate
import java.util.stream.Collectors
import java.util.stream.StreamSupport

fun <T> any(collection: Collection<T>, predicate: Predicate<in T>): Boolean {
  return collection.stream().anyMatch { predicate.test(it) }
}

fun <T> filter(collection: Iterable<T>, predicate: Predicate<in T>): List<T> {
  return StreamSupport.stream(collection.spliterator(), false).filter { predicate.test(it) }.collect(Collectors.toList())
}