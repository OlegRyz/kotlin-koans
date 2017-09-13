package iv_properties

import util.TODO
import util.doc34
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int by MyDelegate(initializer)
}

class MyDelegate(val initializer: () -> Int) {
    var isInitialized = false
    var value = 0
    operator fun getValue(motherClass: LazyPropertyUsingDelegates?, property: KProperty<*>): Int {
        if (!isInitialized) {
            value = initializer()
            isInitialized = true
        }
        return value
    }
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)
