package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class SetName {
    public static void setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            carName = carName.trim();

            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (carName.matches(".*\\d+.*")) {
                throw new IllegalArgumentException("자동차 이름에 숫자가 포함되어 있습니다.");
            }

            System.out.println("입력된 자동차 이름: " + carName);
        }
    }
}
