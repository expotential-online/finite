package online.expotential.finite.core.mappers.builders

import online.expotential.finite.core.mappers.Mapper

fun interface MapperBuilder<D, R> {
    fun build(): Mapper<D, R>
}
