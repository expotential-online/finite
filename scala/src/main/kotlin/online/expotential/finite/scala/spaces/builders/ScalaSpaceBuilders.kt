package online.expotential.finite.scala.spaces.builders

import online.expotential.finite.core.spaces.builders.FiniteSpaceBuilder
import online.expotential.finite.core.spaces.builders.StandardFiniteSpaceBuilder
import online.expotential.finite.scala.ScalaUtil.MODULE_FIELD_NAME
import java.util.*

object ScalaSpaceBuilders {

    @JvmStatic
    fun <T> spaceForObjectOfObjects(caseClass: Class<T>): FiniteSpaceBuilder<T> {
        val items = caseClass.declaredClasses
            .asSequence()
            .filter { caseClass == it.superclass }
            .map { c ->
                try {
                    caseClass.cast(c.getDeclaredField(MODULE_FIELD_NAME)[c])
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
