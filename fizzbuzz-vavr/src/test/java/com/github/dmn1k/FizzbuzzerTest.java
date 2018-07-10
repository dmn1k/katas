package com.github.dmn1k;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzbuzzerTest {
    @ParameterizedTest
    @CsvSource({
            "3",
            "6",
            "9",
            "12"
    })
    public void returnsFizzForMultiplesOfThree(int input){
        Fizzbuzzer fizzbuzzer = new Fizzbuzzer();

        Stream<String> result = fizzbuzzer.transform();

        assertThat(result.get(input - 1)).isEqualTo("Fizz");
    }


    @ParameterizedTest
    @CsvSource({
            "5",
            "10",
            "20"
    })
    public void returnsBuzzForMultiplesOfFive(int input){
        Fizzbuzzer fizzbuzzer = new Fizzbuzzer();

        Stream<String> result = fizzbuzzer.transform();

        assertThat(result.get(input - 1)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @CsvSource({
            "15",
            "30",
            "45"
    })
    public void returnsFizzBuzzForMultiplesOfThreeAndFive(int input){
        Fizzbuzzer fizzbuzzer = new Fizzbuzzer();

        Stream<String> result = fizzbuzzer.transform();

        assertThat(result.get(input - 1)).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
            "4",
            "7"
    })
    public void returnsInputDigitIfNoMultipleOfThreeOrFive(int input){
        Fizzbuzzer fizzbuzzer = new Fizzbuzzer();

        Stream<String> result = fizzbuzzer.transform();

        assertThat(result.get(input - 1)).isEqualTo(Integer.toString(input));
    }
}
