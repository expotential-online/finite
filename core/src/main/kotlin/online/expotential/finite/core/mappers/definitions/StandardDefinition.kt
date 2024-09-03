package online.expotential.finite.core.mappers.definitions

import online.expotential.finite.core.spaces.FiniteSpace
import online.expotential.finite.core.spaces.Space

class StandardDefinition<D, R> internal constructor(
    private val name: String,
    private val domain: FiniteSpace<D>,
    private val range: Space<R>,
    private val map: MutableMap<D, R>,
    private val antiMap: MutableMap<D, String>
) : Definition<D, R> {

    override fun mapping(domainValue: D, rangeValue: R): Definition<D, R> =
        apply { map[domainValue] = rangeValue }

    override fun notMappingWithReason(domainValue: D, reason: String): Definition<D, R> =
        apply { antiMap[domainValue] = reason }

    override fun name(): String = name
    override fun domain(): FiniteSpace<D> = domain
    override fun range(): Space<R> = range
    override fun mappings(): Map<D, R> = map
    override fun reasonsForNotMapping(): Map<D, String> = antiMap
}
