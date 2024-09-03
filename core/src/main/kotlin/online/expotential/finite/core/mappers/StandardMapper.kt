package online.expotential.finite.core.mappers

import mu.KLogger
import mu.KotlinLogging.logger
import online.expotential.finite.core.mappers.exceptions.NotMappedException
import online.expotential.finite.core.mappers.messages.MapperMessages.mappedMessage
import online.expotential.finite.core.mappers.messages.MapperMessages.notMappedMessage
import online.expotential.finite.core.mappers.messages.MapperMessages.notMappedWithReasonMessage
import online.expotential.finite.core.spaces.FiniteSpace
import online.expotential.finite.core.spaces.Space

class StandardMapper<D, R> internal constructor(
    private val name: String,
    private val domain: FiniteSpace<D>,
    private val range: Space<R>,
    private val map: Map<D, R>,
    private val antiMap: Map<D, String>
) : Mapper<D, R> {

    private val logger: KLogger = logger { }

    override fun mapOrNull(domainValue: D): R? = mapOrDo(domainValue, logger::warn, logger::error)

    override fun mapOrThrow(domainValue: D): R =
        mapOrDo(domainValue, this::throwNotMappedException, this::throwNotMappedException)!!

    override fun isMapping(domainValue: D): Boolean = map.containsKey(domainValue)

    override fun isNotMapping(domainItem: D): Boolean = !isMapping(domainItem)

    override fun isNotMappingWithReason(domainItem: D): Boolean =
        isNotMapping(domainItem) && antiMap.containsKey(domainItem)

    override fun reasonForNotMappingOrNull(domainItem: D): String? = antiMap[domainItem]

    private fun throwNotMappedException(message: String): Unit = throw NotMappedException(message)

    private fun mapOrDo(
        domainValue: D,
        onNotMappedWithReason: (String) -> Unit,
        onNotMappedWithNoReason: (String) -> Unit
    ): R? {
        val rangeValue = map[domainValue]
        if (rangeValue == null) {
            val reason = reasonForNotMappingOrNull(domainValue)
            if (reason == null) {
                onNotMappedWithNoReason.invoke(notMappedMessage(name, domain, domainValue, range))
            } else {
                onNotMappedWithReason.invoke(notMappedWithReasonMessage(domain, domainValue, range, reason))
            }
        } else {
            logger.debug { mappedMessage(name, domain, domainValue, range, rangeValue) }
        }
        return rangeValue
    }
}
