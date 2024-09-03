package online.expotential.finite.core.mappers.definitions.starters

import online.expotential.finite.core.mappers.definitions.rangespecifiers.EnumDomainRangeSpecifier
import online.expotential.finite.core.mappers.definitions.rangespecifiers.RangeSpecifier
import online.expotential.finite.core.spaces.FiniteSpace
import online.expotential.finite.core.spaces.builders.SpaceBuilders.finiteSpaceForEnumClass

class StandardEnumStarter internal constructor(private var name: String) : EnumStarter {

    override fun named(name: String): EnumStarter = apply { this.name = name }

    override fun <D : Enum<D>> forDomain(domain: FiniteSpace<D>): RangeSpecifier<D> =
        EnumDomainRangeSpecifier(name, domain)

    override fun <D : Enum<D>> forDomain(domain: Class<D>): RangeSpecifier<D> =
        forDomain(finiteSpaceForEnumClass(domain).build())
}
