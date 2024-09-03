package online.expotential.finite.core.mappers.definitions.starters

import online.expotential.finite.core.mappers.definitions.rangespecifiers.NonEnumDomainRangeSpecifier
import online.expotential.finite.core.mappers.definitions.rangespecifiers.RangeSpecifier
import online.expotential.finite.core.spaces.FiniteSpace

class StandardNonEnumStarter internal constructor(private var name: String) :
    NonEnumStarter {

    override fun named(name: String): NonEnumStarter = apply { this.name = name }

    override fun <D> forDomain(domain: FiniteSpace<D>): RangeSpecifier<D> =
        NonEnumDomainRangeSpecifier(name, domain)
}
