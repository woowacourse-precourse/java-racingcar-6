package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class NameInput {

    static String[] nameArr;

    static void getNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        nameArr = input.split(",");
    }

    static void checkNameInput() throws IllegalArgumentException {
        for (String name: nameArr) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    static Car[] setNameInput() {
        int n = nameArr.length;
        Car[] carArr = new Car[n];
        for (int idx = 0; idx < n; idx++) {
            carArr[idx] = new Car(nameArr[idx], 0);
        }
        return carArr;
    }

    public static String[] getNameArr() {
        return nameArr;
    }

    public static void setNameArr(String[] nameArr) {
        NameInput.nameArr = nameArr;
    }
}
