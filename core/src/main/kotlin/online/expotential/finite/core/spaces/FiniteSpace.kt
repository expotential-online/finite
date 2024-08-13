package online.expotential.finite.core.spaces

interface FiniteSpace<T> : Space<T> {
    fun items(): Set<T>
}
