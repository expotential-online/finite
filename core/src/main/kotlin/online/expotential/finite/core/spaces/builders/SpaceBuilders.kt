package online.expotential.finite.core.spaces.builders

import online.expotential.finite.core.spaces.defaults.SpaceDefaults.defaultItems

object SpaceBuilders {

    @JvmStatic
    fun <T> spaceForClass(spaceClass: Class<T>): SpaceBuilder<T> = StandardSpaceBuilder(spaceClass)

    @JvmStatic
    fun <E : Enum<E>> finiteSpaceForEnumClass(spaceClass: Class<E>): FiniteSpaceBuilder<E> =
        StandardFiniteSpaceBuilder(spaceClass, defaultItems(spaceClass))
}
