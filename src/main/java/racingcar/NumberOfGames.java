package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class NumberOfGames {

    public int numOfGames() { //게임 진행 횟수 설정
        String input = InputString.inputNumOfGames();
        return validation(input);
    }

    public int validation(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 1) {
                throw new IllegalArgumentException("게임 진행 횟수는 1회 이상 이어야 합니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1이상의 정수를 입력하세요.");
        }
    }
}
