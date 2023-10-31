package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CountInput {

    static private int count;

    static String getCountInput() { // 회차 입력 받는 메서드
        String input = Console.readLine();
        Console.close();
        return input;
    }



}
