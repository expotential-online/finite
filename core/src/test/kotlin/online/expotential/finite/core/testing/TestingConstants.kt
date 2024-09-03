package online.expotential.finite.core.testing

import online.expotential.finite.core.mappers.exceptions.NotMappedException
import online.expotential.finite.core.spaces.builders.FiniteSpaceBuilder
import online.expotential.finite.core.spaces.builders.StandardFiniteSpaceBuilder

object TestingConstants {

    const val DOG = 1
    const val PARROT = 9

    val items: Set<Int> = setOf(DOG, PARROT)

    fun camelCase(number: Int): String = when (number) {
        DOG -> "Dog"
        PARROT -> "Parrot"
        else -> throw NotMappedException("Animal number $number is unknown")
    }

    fun finiteSpace(): FiniteSpaceBuilder<Int> = StandardFiniteSpaceBuilder(Int::class.java, items)
}
