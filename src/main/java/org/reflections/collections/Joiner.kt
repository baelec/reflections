@file:JvmName("Joiner")


package org.reflections.collections

fun on(joiner: String, list: List<String>) {
  list.joinToString { joiner }
}