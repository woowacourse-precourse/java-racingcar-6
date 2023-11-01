package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int MAX_NAME_SIZE = 5;

    private static String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine().replaceAll("[^a-zA-Z0-9,]", "");
        System.out.println(carNamesInput);

        String[] carNamesArray = carNamesInput.split(",");
        for (int i = 0; i < carNamesArray.length; i++) {
            if (carNamesArray[i].length() > MAX_NAME_SIZE) {
                throw new IllegalArgumentException();
            }
        }
        return carNamesArray;
    }

    public static void main(String[] args) {
        String[] carNamesArray = inputNames();
    }
}
