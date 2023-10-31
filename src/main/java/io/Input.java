package io;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.creation.SuspendMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Input {
    public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    String[] splitByComma(String input) {
        return input.split(",");
    }

    ArrayList<String> receiveCommaSeparatedString() {
        String input = prompt(START_MESSAGE);
        String[] inputArray = splitByComma(input);

        return new ArrayList<>(Arrays.asList(inputArray));
    }

    Integer receiveInteger() {
        int number;
        String input = prompt(INPUT_MESSAGE);

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(input + "은, 정수가 아닙니다!");
        }
        return number;
    }

    String prompt(String greeting) {
        String input;
        System.out.println(greeting);

        try {
            input = Console.readLine();
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력을 해주세요!");
        }
        return input;
    }
}
