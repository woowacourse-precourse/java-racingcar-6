package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class NumberOfGames {
    public int  numOfGames() { //게임 진행 횟수 설정
        String input = InputString.inputNumOfGames();
        return validation(input);
    }

    private int validation(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 1) {
                throw new IllegalArgumentException("1 이상의 정수를 입력하세요.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}
