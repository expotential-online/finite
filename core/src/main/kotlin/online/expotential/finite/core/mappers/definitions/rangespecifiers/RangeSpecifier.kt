package online.expotential.finite.core.mappers.definitions.rangespecifiers

import online.expotential.finite.core.mappers.definitions.Definition
import online.expotential.finite.core.spaces.Space

interface RangeSpecifier<D> {
    fun <R> andRange(range: Space<R>): Definition<D, R>
    fun <R : Enum<R>> andRange(range: Class<R>): Definition<D, R>
}
