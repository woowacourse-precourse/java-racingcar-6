package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputTries {
    public static int getTries() {
        String input = Console.readLine();
        int tries=Integer.parseInt(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수를 입력하세요.");
        }
    }
}