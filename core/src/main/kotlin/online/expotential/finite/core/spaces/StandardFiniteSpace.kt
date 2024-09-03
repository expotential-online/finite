package online.expotential.finite.core.spaces

data class StandardFiniteSpace<T> internal constructor(
    private val spaceClass: Class<T>,
    private val description: String,
    private val items: Set<T>,
    private val itemDescriber: ItemDescriber<T>
) : FiniteSpace<T> {
    override fun spaceClass(): Class<T> = spaceClass
    override fun description(): String = description
    override fun describeItem(item: T): String = itemDescriber.invoke(item)
    override fun items(): Set<T> = items
    override fun toString(): String = "Space [$description] containing items $items"
}
