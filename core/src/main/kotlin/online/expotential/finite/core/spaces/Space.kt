package online.expotential.finite.core.spaces

interface Space<T> {
    fun spaceClass(): Class<T>
    fun description(): String
    fun describeItem(item: T): String
}
