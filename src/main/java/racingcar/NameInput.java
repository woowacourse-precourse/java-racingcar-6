package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class NameInput {

    static String[] getNameInput() {   // 이름을 입력받는 함수
        String input = Console.readLine();
        Console.close();
        String[] nameArr = input.split(",");
        return nameArr;
    }

    static void checkNameInput(String[] nameArr) throws IllegalArgumentException {     // 이름을 체크하는 함수
        for (String name: nameArr) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

}
