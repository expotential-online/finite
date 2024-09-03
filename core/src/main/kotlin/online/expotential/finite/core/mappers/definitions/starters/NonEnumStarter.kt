package online.expotential.finite.core.mappers.definitions.starters

import online.expotential.finite.core.mappers.definitions.rangespecifiers.RangeSpecifier
import online.expotential.finite.core.spaces.FiniteSpace

interface NonEnumStarter {
    fun named(name: String): NonEnumStarter
    fun <D> forDomain(domain: FiniteSpace<D>): RangeSpecifier<D>
}
