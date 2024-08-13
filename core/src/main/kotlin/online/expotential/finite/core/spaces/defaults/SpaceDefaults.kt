package online.expotential.finite.core.spaces.defaults

import online.expotential.finite.core.spaces.ItemDescriber

object SpaceDefaults {

    @JvmStatic
    fun <T> defaultSpaceDescription(spaceClass: Class<T>): String = spaceClass.simpleName

    @JvmStatic
    fun <T> defaultItemDescriber(): ItemDescriber<T> = { it.toString() }

    @JvmStatic
    fun <E : Enum<E>> defaultItems(spaceClass: Class<E>): Set<E> = spaceClass.enumConstants.toSet()
}
