package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

// 시도횟수 저장 & 검사
public class InputCount {

    private final int count;

    public InputCount() {

        try {
            String input = Console.readLine();
            count = Integer.parseInt(input);

            if (count < 1) {
                throw new IllegalArgumentException("양수만 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }

    }

    public int getCount() {
        return count;
    }

}
