package com.github.dmn1k;

import io.vavr.collection.List;
import io.vavr.collection.Stream;

public class Fizzbuzzer {
    public List<String> transform(int upperBound) {
        Stream<String> fizzes = Stream.of("", "", "Fizz").cycle();
        Stream<String> buzzes = Stream.of("", "", "", "", "Buzz").cycle();
        Stream<String> numbers = Stream.from(1).map(i -> Integer.toString(i));

        return fizzes
                .zipWith(buzzes, String::concat)
                .zipWith(numbers, (in, digit) -> in.isEmpty() ? digit : in)
                .take(upperBound)
                .toList();
    }
}
