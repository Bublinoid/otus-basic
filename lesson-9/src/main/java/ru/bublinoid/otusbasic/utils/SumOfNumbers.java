package ru.bublinoid.otusbasic.utils;

import java.util.List;

public class SumOfNumbers {


    public static int sumGreaterThanFive(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 5)
                .mapToInt(Integer::intValue)
                .sum();
    }
}