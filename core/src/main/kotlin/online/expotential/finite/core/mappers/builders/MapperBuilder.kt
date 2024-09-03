package online.expotential.finite.core.mappers.builders

import online.expotential.finite.core.mappers.Mapper

interface MapperBuilder<D, R> {
    fun build(): Mapper<D, R>
}
