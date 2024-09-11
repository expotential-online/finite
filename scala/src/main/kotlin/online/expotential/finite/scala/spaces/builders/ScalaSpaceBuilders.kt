package online.expotential.finite.scala.spaces.builders

import mu.KLogger
import mu.KotlinLogging.logger
import online.expotential.finite.core.spaces.builders.FiniteSpaceBuilder
import online.expotential.finite.core.spaces.builders.StandardFiniteSpaceBuilder
import online.expotential.finite.scala.ScalaUtil.MODULE_FIELD_NAME
import java.util.Objects

object ScalaSpaceBuilders {

    private val logger: KLogger = logger { }

    @JvmStatic
    fun <T> spaceForObjectOfObjects(caseClass: Class<T>): FiniteSpaceBuilder<T> {
        val items = caseClass.declaredClasses
            .filter { caseClass == it.superclass }
            .map { c ->
                try {
                    caseClass.cast(c.getDeclaredField(MODULE_FIELD_NAME).get(c))
                } catch (e: NoSuchFieldException) {
                    null
                }
            }
            .filter(Objects::nonNull)
            .map { it!! }
            .toSet()
        return StandardFiniteSpaceBuilder(caseClass, items)
    }
}
