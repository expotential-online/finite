package online.expotential.finite.core.mappers.builders

import online.expotential.finite.core.mappers.Mapper
import online.expotential.finite.core.mappers.StandardMapper
import online.expotential.finite.core.mappers.definitions.Definition
import online.expotential.finite.core.mappers.definitions.starters.EnumStarter
import online.expotential.finite.core.mappers.definitions.starters.StandardEnumStarter

abstract class AbstractEnumMapperBuilder<D : Enum<D>, R> : MapperBuilder<D, R> {

    protected abstract fun completeAndReturnDefinition(definition: EnumStarter)
            : Definition<D, R>

    override fun build(): Mapper<D, R> {
        val definition = completeAndReturnDefinition(StandardEnumStarter(javaClass.simpleName))
        return StandardMapper(
            definition.name(),
            definition.domain(),
            definition.range(),
            definition.mappings(),
            definition.reasonsForNotMapping()
        )
    }
}
