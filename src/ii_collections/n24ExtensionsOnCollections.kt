package ii_collections

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import util.TODO

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { s -> s.length }

    return groupsByLength.values.maxBy { group -> group.size }
}

