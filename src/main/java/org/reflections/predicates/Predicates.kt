@file:JvmName("Predicates")

package org.reflections.predicates

import java.util.*
import java.util.function.Predicate

fun <T> and(predicates: Array<Predicate<in T>>): Predicate<T> {
  return Predicate { value -> Arrays.stream(predicates).allMatch { it.test(value)} }
}

fun <T> alwaysTrue() = Predicate<T> { true }

fun <T> not(predicate: Predicate<in T>): Predicate<T> {
  return Predicate { value -> !predicate.test(value) }
}

fun <T> has(collection: Collection<T>): Predicate<T> {
  return Predicate { value -> collection.contains(value) }
}