package online.expotential.finite.core.spaces.builders

import online.expotential.finite.core.spaces.FiniteSpace
import online.expotential.finite.core.spaces.ItemDescriber

interface FiniteSpaceBuilder<T> {
    fun withDescription(description: String): FiniteSpaceBuilder<T>
    fun withItemDescriber(itemDescriber: ItemDescriber<T>): FiniteSpaceBuilder<T>
    fun build(): FiniteSpace<T>
}
