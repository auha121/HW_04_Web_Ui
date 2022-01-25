package ru.gb.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.lesson.providers.InvalidTriangleProvider;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Тесты. Площадь треугольника")
public class TriangleTestSqrt {

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(3, 3, 3), 3),
                Arguments.of(new Triangle(3, 4, 6), 5)
        );
    }

    @DisplayName("Тесты на площадь разных видов треугольника")
    @ParameterizedTest(name = "Периметр треугольника {0} равен {1}")
    @MethodSource("triangles")
    public void countSqrtTriangleTest(Triangle triangle, int expectedSqrt) {
        int sqrt = triangle.countSqrt();
        assertThat(sqrt).isEqualTo(expectedSqrt);
    }

    @DisplayName("Тест на отлавливание ошибки")
    @ParameterizedTest
    @ArgumentsSource(InvalidTriangleProvider.class)
    public void sqrtInvalidTriangleNegativeTestTest(Triangle triangle) {
        assertThatThrownBy(triangle::countSqrt)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The triangle must be valid");
    }
}
