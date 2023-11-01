package io;

import static constant.Constant.ATTEMPTS_NUMBER_REQUEST_MESSAGE;
import static constant.Constant.CAR_NAME_REQUEST_MESSAGE;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class UserInput {
    private final Converter converter;

    public UserInput(Converter converter) {
        this.converter = converter;
    }

    public int getAttemptsNumber() {
        println(ATTEMPTS_NUMBER_REQUEST_MESSAGE);
        String attemptsString = Console.readLine();
        return converter.wordToInt(attemptsString);
    }

    public LinkedHashMap<String, String> getCarNameHashMap() {
        println(CAR_NAME_REQUEST_MESSAGE);
        String carName = Console.readLine();
        return converter.splitAndAddToMap(carName);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }
}