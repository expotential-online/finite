package online.expotential.finite.core.spaces

data class StandardFiniteSpace<T> internal constructor(
    private val description: String,
    private val itemDescriber: ItemDescriber<T>,
    private val items: Set<T>
) : FiniteSpace<T> {
    override fun description(): String = description
    override fun describeItem(item: T): String = itemDescriber.invoke(item)
    override fun items(): Set<T> = items
}
