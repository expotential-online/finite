package online.expotential.finite.core.mappers.builders

import online.expotential.finite.core.mappers.Mapper
import online.expotential.finite.core.mappers.definitions.Definition
import online.expotential.finite.core.mappers.definitions.starters.NonEnumStarter
import online.expotential.finite.core.mappers.exceptions.NotMappedException
import online.expotential.finite.core.spaces.builders.SpaceBuilders.spaceForClass
import online.expotential.finite.core.testing.TestingConstants
import online.expotential.finite.core.testing.TestingConstants.DOG
import online.expotential.finite.core.testing.TestingConstants.PARROT
import online.expotential.finite.core.testing.TestingConstants.finiteSpace
import online.expotential.finite.core.testing.TestingRange
import online.expotential.finite.core.testing.TestingRange.BIRD
import online.expotential.finite.core.testing.TestingRange.MAMMAL
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("A non-enum mapper")
class AbstractNonEnumMapperBuilderTest {

    private val parrotNotMappedReason = "Is an ex-parrot a bird?"

    @Test
    @DisplayName("should support overriding name")
    fun testNaming() {
        object : AbstractNonEnumMapperBuilder<Int, TestingRange>() {
            override fun completeAndReturnDefinition(definition: NonEnumStarter)
                    : Definition<Int, TestingRange> {
                return definition
                    .named("Animal mapper")
                    .forDomain(finiteSpace().build())
                    .andRange(TestingRange::class.java)
                    .mapping(DOG, MAMMAL)
                    .mapping(PARROT, BIRD)
            }
        }.build()
    }

    @Test
    @DisplayName("should support exhaustive mapping to range class")
    fun test1() {

        val mapper = object : AbstractNonEnumMapperBuilder<Int, TestingRange>() {
            override fun completeAndReturnDefinition(definition: NonEnumStarter): Definition<Int, TestingRange> {
                return definition
                    .forDomain(
                        finiteSpace()
                            .withDescription("Animal")
                            .withItemDescriber(TestingConstants::camelCase)
                            .build()
                    )
                    .andRange(TestingRange::class.java)
                    .mapping(DOG, MAMMAL)
                    .mapping(PARROT, BIRD)
            }
        }.build()

        assertExhaustive(mapper)
    }

    @Test
    @DisplayName("should support exhaustive mapping to range space")
    fun test2() {

        val mapper = object : AbstractNonEnumMapperBuilder<Int, TestingRange>() {
            override fun completeAndReturnDefinition(definition: NonEnumStarter): Definition<Int, TestingRange> {
                return definition
                    .forDomain(
                        finiteSpace()
                            .withDescription("Animal")
                            .withItemDescriber(TestingConstants::camelCase)
                            .build()
                    )
                    .andRange(
                        spaceForClass(TestingRange::class.java)
                            .withDescription("Animal class")
                            .withItemDescriber { it.camelCase }
                            .build())
                    .mapping(DOG, MAMMAL)
                    .mapping(PARROT, BIRD)
            }
        }.build()

        assertExhaustive(mapper)
    }

    @Test
    @DisplayName("should support reasoned non-exhaustive mapping to range class")
    fun test3() {

        val mapper = object : AbstractNonEnumMapperBuilder<Int, TestingRange>() {
            override fun completeAndReturnDefinition(definition: NonEnumStarter): Definition<Int, TestingRange> {
                return definition
                    .forDomain(
                        finiteSpace()
                            .withDescription("Animal")
                            .withItemDescriber(TestingConstants::camelCase)
                            .build()
                    )
                    .andRange(TestingRange::class.java)
                    .mapping(DOG, MAMMAL)
                    .notMappingWithReason(PARROT, parrotNotMappedReason)
            }
        }.build()

        assertReasonedNonExhaustive(mapper)
    }

    @Test
    @DisplayName("should support reasoned non-exhaustive mapping to range space")
    fun test4() {

        val mapper = object : AbstractNonEnumMapperBuilder<Int, TestingRange>() {
            override fun completeAndReturnDefinition(definition: NonEnumStarter): Definition<Int, TestingRange> {
                return definition
                    .forDomain(
                        finiteSpace()
                            .withDescription("Animal")
                            .withItemDescriber(TestingConstants::camelCase)
                            .build()
                    )
                    .andRange(
                        spaceForClass(TestingRange::class.java)
                            .withDescription("Animal class")
                            .withItemDescriber { it.camelCase }
                            .build())
                    .mapping(DOG, MAMMAL)
                    .notMappingWithReason(PARROT, parrotNotMappedReason)
            }
        }.build()

        assertReasonedNonExhaustive(mapper)
    }

    @Test
    @DisplayName("should support unreasoned non-exhaustive mapping to range class")
    fun test5() {

        val mapper = object : AbstractNonEnumMapperBuilder<Int, TestingRange>() {
            override fun completeAndReturnDefinition(definition: NonEnumStarter): Definition<Int, TestingRange> {
                return definition
                    .forDomain(
                        finiteSpace()
                            .withDescription("Animal")
                            .withItemDescriber(TestingConstants::camelCase)
                            .build()
                    )
                    .andRange(TestingRange::class.java)
                    .mapping(DOG, MAMMAL)
            }
        }.build()

        assertUnreasonedNonExhaustive(mapper)
    }

    @Test
    @DisplayName("should support unreasoned non-exhaustive mapping to range space")
    fun test6() {

        val mapper = object : AbstractNonEnumMapperBuilder<Int, TestingRange>() {
            override fun completeAndReturnDefinition(definition: NonEnumStarter): Definition<Int, TestingRange> {
                return definition
                    .forDomain(
                        finiteSpace()
                            .withDescription("Animal")
                            .withItemDescriber(TestingConstants::camelCase)
                            .build()
                    )
                    .andRange(
                        spaceForClass(TestingRange::class.java)
                            .withDescription("Animal class")
                            .withItemDescriber { it.camelCase }
                            .build())
                    .mapping(DOG, MAMMAL)
            }
        }.build()

        assertUnreasonedNonExhaustive(mapper)
    }

    private fun assertExhaustive(mapper: Mapper<Int, TestingRange>) {
        assertEquals(MAMMAL, mapper.mapOrNull(DOG))
        assertEquals(BIRD, mapper.mapOrNull(PARROT))
        assertEquals(MAMMAL, mapper.mapOrThrow(DOG))
        assertEquals(BIRD, mapper.mapOrThrow(PARROT))

        assertTrue(mapper.isMapping(DOG))
        assertTrue(mapper.isMapping(PARROT))

        assertFalse(mapper.isNotMapping(DOG))
        assertFalse(mapper.isNotMapping(PARROT))

        assertFalse(mapper.isNotMappingWithReason(DOG))
        assertFalse(mapper.isNotMappingWithReason(PARROT))

        assertNull(mapper.reasonForNotMappingOrNull(DOG))
        assertNull(mapper.reasonForNotMappingOrNull(PARROT))
    }

    private fun assertReasonedNonExhaustive(mapper: Mapper<Int, TestingRange>) {
        assertEquals(MAMMAL, mapper.mapOrNull(DOG))
        assertNull(mapper.mapOrNull(PARROT))
        assertEquals(MAMMAL, mapper.mapOrThrow(DOG))
        assertThrows(NotMappedException::class.java) { mapper.mapOrThrow(PARROT) }

        assertTrue(mapper.isMapping(DOG))
        assertFalse(mapper.isMapping(PARROT))

        assertFalse(mapper.isNotMapping(DOG))
        assertTrue(mapper.isNotMapping(PARROT))

        assertFalse(mapper.isNotMappingWithReason(DOG))
        assertTrue(mapper.isNotMappingWithReason(PARROT))

        assertNull(mapper.reasonForNotMappingOrNull(DOG))
        assertEquals(parrotNotMappedReason, mapper.reasonForNotMappingOrNull(PARROT))
    }

    private fun assertUnreasonedNonExhaustive(mapper: Mapper<Int, TestingRange>) {
        assertEquals(MAMMAL, mapper.mapOrNull(DOG))
        assertNull(mapper.mapOrNull(PARROT))
        assertEquals(MAMMAL, mapper.mapOrThrow(DOG))
        assertThrows(NotMappedException::class.java) { mapper.mapOrThrow(PARROT) }

        assertTrue(mapper.isMapping(DOG))
        assertFalse(mapper.isMapping(PARROT))

        assertFalse(mapper.isNotMapping(DOG))
        assertTrue(mapper.isNotMapping(PARROT))

        assertFalse(mapper.isNotMappingWithReason(DOG))
        assertFalse(mapper.isNotMappingWithReason(PARROT))

        assertNull(mapper.reasonForNotMappingOrNull(DOG))
        assertNull(mapper.reasonForNotMappingOrNull(PARROT))
    }
}
