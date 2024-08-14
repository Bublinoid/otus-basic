package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.thread.FourThreadArray;
import ru.bublinoid.otusbasic.thread.OneThreadArray;

public class Main {
    public static void main(String[] args) {

        OneThreadArray.RunOneThreadArray();
        FourThreadArray.RunFourThreadArray();
    }
}