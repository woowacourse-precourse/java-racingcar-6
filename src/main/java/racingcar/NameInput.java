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

    static Car[] setNameInput(String[] nameArr, int n) {     // 이름으로 Car 인스턴스를 생성하는 함수
        Car[] carArr = new Car[n];
        for (int idx = 0; idx < n; idx++) {
            carArr[idx] = new Car(nameArr[idx], 0);
        }
        return carArr;
    }
}
