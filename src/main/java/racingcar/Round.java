package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Round {

    // 사용자로부터 시도할 횟수 입력 받기
    public static int getRound() {
        int round = 0;
        String inputValue = Console.readLine();
        String regexp = "^[0-9]+$";

        if(!inputValue.matches(regexp)){
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
        }

        round = Integer.parseInt(inputValue);

        return round;
    }

}
