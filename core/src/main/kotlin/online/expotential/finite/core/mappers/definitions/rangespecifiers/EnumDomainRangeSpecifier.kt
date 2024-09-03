package online.expotential.finite.core.mappers.definitions.rangespecifiers

import online.expotential.finite.core.mappers.definitions.Definition
import online.expotential.finite.core.mappers.definitions.StandardDefinition
import online.expotential.finite.core.spaces.FiniteSpace
import online.expotential.finite.core.spaces.Space
import online.expotential.finite.core.spaces.builders.SpaceBuilders.spaceForClass
import java.util.*

class EnumDomainRangeSpecifier<D : Enum<D>> internal constructor(
    private val name: String,
    private val domain: FiniteSpace<D>
) : RangeSpecifier<D> {

    override fun <R> andRange(range: Space<R>): Definition<D, R> =
        StandardDefinition(
            name, domain, range, EnumMap(domain.spaceClass()), EnumMap<D, String>(domain.spaceClass())
        )

    override fun <R : Enum<R>> andRange(range: Class<R>): Definition<D, R> =
        andRange(spaceForClass(range).build())
}
