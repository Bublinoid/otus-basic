package ru.bublinoid.otusbasic.utils;

import java.util.ArrayList;

public class SequentialValuesGenerator {

    public static ArrayList<Integer> generateSequentialValues(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            result.add(i);
        }
        return result;
    }
}