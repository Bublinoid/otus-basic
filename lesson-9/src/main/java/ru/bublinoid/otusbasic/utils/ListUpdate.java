package ru.bublinoid.otusbasic.utils;

import java.util.List;

public class ListUpdate {

    public static void updateListWithNumber(int number, List<Integer> numbers) {

        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, number);
        }
    }

    public static void zoomListElement(int zoom, List<Integer> numbers) {

        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i) + zoom);
        }
    }
}