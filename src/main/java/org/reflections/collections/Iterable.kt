@file:JvmName("Iterables")

package org.reflections.collections

import java.util.function.Predicate
import java.util.stream.Collectors
import java.util.stream.Stream
import java.util.stream.StreamSupport

fun <T> concat(iter0: Iterable<T>, iter1: Iterable<T>): Iterable<T> {
  val stream0 = StreamSupport.stream(iter0.spliterator(), false)
  val stream1 = StreamSupport.stream(iter1.spliterator(), false)
  return Stream.concat(stream0, stream1).collect(Collectors.toList())
}

fun <T> any(collection: Collection<T>, predicate: Predicate<in T>): Boolean {
  return collection.stream().anyMatch { predicate.test(it) }
}

fun <T> filter(collection: Stream<T>, predicate: Predicate<in T>): List<T> {
  return StreamSupport.stream(collection.spliterator(), false).filter { predicate.test(it) }.collect(Collectors.toList())
}