package online.expotential.finite.core.mappers

import online.expotential.finite.core.mappers.exceptions.NotMappedException

interface Mapper<D, R> {
    fun mapOrNull(domainValue: D): R?
    @Throws(NotMappedException::class)
    fun mapOrThrow(domainValue: D): R
    fun isMapping(domainValue: D): Boolean
    fun isNotMapping(domainItem: D): Boolean
    fun isNotMappingWithReason(domainItem: D): Boolean
    fun reasonForNotMappingOrNull(domainItem: D): String?
}
