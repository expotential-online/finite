package online.expotential.finite.core.mappers.messages

import online.expotential.finite.core.spaces.Space

object MapperMessages {

    @JvmStatic
    fun <D> notMappedMessage(mapperName: String, domain: Space<D>, domainItem: D, range: Space<*>): String =
        "Mapper [${
            mapperName
        }] unable to map value [${
            domain.describeItem(domainItem)
        }] from domain [${
            domain.description()
        }] to range [${
            range.description()
        }]"

    @JvmStatic
    fun <D, R> mappedMessage(
        mapperName: String,
        domain: Space<D>,
        domainItem: D,
        range: Space<R>,
        rangeItem: R
    ): String =
        "Mapper [${
            mapperName
        }] mapped value [${
            domain.describeItem(domainItem)
        }] from domain [${
            domain.description()
        }] to [${
            range.describeItem(rangeItem)
        }] in range [${
            range.description()
        }]"

    @JvmStatic
    fun <D> notMappedWithReasonMessage(domain: Space<D>, domainItem: D, range: Space<*>, reason: String): String =
        "Unable to map value [${
            domain.describeItem(domainItem)
        }] from domain [${
            domain.description()
        }] to range [${
            range.description()
        }] for reason [${
            reason
        }]"
}
