package online.expotential.finite.core.mappers.definitions

import online.expotential.finite.core.spaces.FiniteSpace
import online.expotential.finite.core.spaces.Space

interface Definition<D, R> {

    fun mapping(domainValue: D, rangeValue: R): Definition<D, R>
    fun notMappingWithReason(domainValue: D, reason: String): Definition<D, R>

    fun domain(): FiniteSpace<D>
    fun range(): Space<R>
    fun name(): String
    fun mappings(): Map<D, R>
    fun reasonsForNotMapping(): Map<D, String>
}
