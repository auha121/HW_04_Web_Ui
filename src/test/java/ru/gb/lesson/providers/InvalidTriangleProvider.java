package ru.gb.lesson.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.gb.lesson.Triangle;

import java.util.stream.Stream;

public class InvalidTriangleProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(Arguments.of(new Triangle(1, 2, 5)), Arguments.of(new Triangle(5, 2, 8)));
    }
}