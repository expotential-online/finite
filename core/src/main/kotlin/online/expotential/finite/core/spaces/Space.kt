package online.expotential.finite.core.spaces

interface Space<T> {
    fun description(): String
    fun describeItem(item: T): String
}
