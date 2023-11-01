package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
    }

    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("5자 이내로 입력해야 합니다.");
            }
        }

        return carNames;
    }
}
