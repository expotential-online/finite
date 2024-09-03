package online.expotential.finite.core.spaces.builders

import online.expotential.finite.core.spaces.ItemDescriber
import online.expotential.finite.core.spaces.Space
import online.expotential.finite.core.spaces.StandardSpace
import online.expotential.finite.core.spaces.defaults.SpaceDefaults.defaultItemDescriber
import online.expotential.finite.core.spaces.defaults.SpaceDefaults.defaultSpaceDescription

class StandardSpaceBuilder<T> internal constructor(private val spaceClass: Class<T>) : SpaceBuilder<T> {

    private var descriptionOrNull: String? = null
    private var itemDescriberOrNull: ItemDescriber<T>? = null

    override fun withDescription(description: String): SpaceBuilder<T> =
        apply { this.descriptionOrNull = description }

    override fun withItemDescriber(itemDescriber: ItemDescriber<T>): SpaceBuilder<T> =
        apply { this.itemDescriberOrNull = itemDescriber }

    override fun build(): Space<T> = StandardSpace(
        spaceClass,
        descriptionOrNull ?: defaultSpaceDescription(spaceClass),
        itemDescriberOrNull ?: defaultItemDescriber()
    )
}
