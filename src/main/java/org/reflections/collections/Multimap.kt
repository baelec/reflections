package org.reflections.collections

import java.util.*

class Multimap<K, V> {
  private val map = HashMap<K, MutableSet<V>>()
  fun get(key: K) : Collection<V>? = map[key]
  fun put(key: K, value: V) {
    map.getOrPut(key, { HashSet() }).add(value)
  }

  fun size() = map.size
}