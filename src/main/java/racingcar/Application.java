package racingcar;

import camp.nextstep.edu.missionutils.*;

public class Application {
    // 자동차 이름을 입력 받는 함수
    public static String[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분해 주세요");
        }
        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해 주세요");
            }
            if (!isOnlyAlphabet(carNames[i])) {
                throw new IllegalArgumentException("자동차 이름은 영어로만 이루어져야 하고, 쉼표로 구분돼야 합니다: " + carNames[i]);
            }
        }
        return carNames;
    }

    public static boolean isOnlyAlphabet(String str) {
        for (int i = 0; i < str.length(); i++) {
            char carName = str.charAt(i);
            if (!(carName >= 'A' && carName <= 'Z') && !(carName >= 'a' && carName <= 'z')) {
                return false;
            }
        }
        return true;
    }

}