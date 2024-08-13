package online.expotential.finite.core.spaces.builders

import online.expotential.finite.core.spaces.ItemDescriber
import online.expotential.finite.core.spaces.Space

interface SpaceBuilder<T> {
    fun withDescription(description: String): SpaceBuilder<T>
    fun withItemDescriber(itemDescriber: ItemDescriber<T>): SpaceBuilder<T>
    fun build(): Space<T>
}
