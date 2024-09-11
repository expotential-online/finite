package online.expotential.finite.core.spaces.builders

import online.expotential.finite.core.spaces.FiniteSpace
import online.expotential.finite.core.spaces.ItemDescriber
import online.expotential.finite.core.spaces.StandardFiniteSpace
import online.expotential.finite.core.spaces.defaults.SpaceDefaults.defaultItemDescriber
import online.expotential.finite.core.spaces.defaults.SpaceDefaults.defaultSpaceDescription

class StandardFiniteSpaceBuilder<T> (
    private val spaceClass: Class<T>,
    private val items: Set<T>
) : FiniteSpaceBuilder<T> {

    private var descriptionOrNull: String? = null
    private var itemDescriberOrNull: ItemDescriber<T>? = null

    override fun withDescription(description: String): FiniteSpaceBuilder<T> =
        apply { this.descriptionOrNull = description }

    override fun withItemDescriber(itemDescriber: ItemDescriber<T>): FiniteSpaceBuilder<T> =
        apply { this.itemDescriberOrNull = itemDescriber }

    override fun build(): FiniteSpace<T> = StandardFiniteSpace(
        spaceClass,
        descriptionOrNull ?: defaultSpaceDescription(spaceClass),
        items,
        itemDescriberOrNull ?: defaultItemDescriber()
    )
}
