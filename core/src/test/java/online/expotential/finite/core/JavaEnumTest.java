package online.expotential.finite.core;

import org.junit.jupiter.api.Test;

class JavaEnumTest {

    @Test
    void testJavaEnum() {
        for (final JavaEnum value : JavaEnum.values()) {
            final String result = switch (value) {
                case VALUE1 -> "v1";
                case VALUE2 -> "v2";
                default -> "v3";
            };
            System.out.println(result);
        }
    }
}
