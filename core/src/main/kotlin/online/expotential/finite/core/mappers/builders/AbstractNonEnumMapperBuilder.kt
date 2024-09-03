package online.expotential.finite.core.mappers.builders

import online.expotential.finite.core.mappers.Mapper
import online.expotential.finite.core.mappers.StandardMapper
import online.expotential.finite.core.mappers.definitions.Definition
import online.expotential.finite.core.mappers.definitions.starters.NonEnumStarter
import online.expotential.finite.core.mappers.definitions.starters.StandardNonEnumStarter

abstract class AbstractNonEnumMapperBuilder<D, R> : MapperBuilder<D, R> {

    protected abstract fun completeAndReturnDefinition(definition: NonEnumStarter): Definition<D, R>

    override fun build(): Mapper<D, R> {
        val definition = completeAndReturnDefinition(StandardNonEnumStarter(javaClass.simpleName))
        return StandardMapper(
            definition.name(),
            definition.domain(),
            definition.range(),
            definition.mappings(),
            definition.reasonsForNotMapping()
        )
    }
}
