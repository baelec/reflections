@file:JvmName("Joiner")

package org.reflections.collections

fun on(joiner: String, list: Collection<Any>): String {
  return list.map { it.toString()}.joinToString { joiner }
}