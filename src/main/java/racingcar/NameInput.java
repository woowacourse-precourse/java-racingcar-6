package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class NameInput {

    static String[] getNameInput() {   // 이름을 입력받는 함수
        String input = Console.readLine();
        Console.close();
        String[] nameArr = input.split(",");
        return nameArr;
    }



}
