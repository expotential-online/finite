package online.expotential.finite.core.mappers.definitions.starters

import online.expotential.finite.core.mappers.definitions.rangespecifiers.RangeSpecifier
import online.expotential.finite.core.spaces.FiniteSpace

interface EnumStarter {
    fun named(name: String): EnumStarter
    fun <D : Enum<D>> forDomain(domain: FiniteSpace<D>): RangeSpecifier<D>
    fun <D : Enum<D>> forDomain(domain: Class<D>): RangeSpecifier<D>
}
