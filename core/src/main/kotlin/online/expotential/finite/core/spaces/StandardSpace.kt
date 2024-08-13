package online.expotential.finite.core.spaces

data class StandardSpace<T> internal constructor(
    private val description: String,
    private val itemDescriber: ItemDescriber<T>
) : Space<T> {
    override fun description(): String = description
    override fun describeItem(item: T): String = itemDescriber.invoke(item)
}
