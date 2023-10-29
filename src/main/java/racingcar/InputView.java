package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String carNamesInput = Console.readLine();
        if (!isValidCarNames(carNamesInput)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분하고, 5자 이하로 입력해야 합니다.");
        }
        return carNamesInput;
    }

    private static boolean isValidCarNames(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static int getTryCount() {
        System.out.print("시도할 횟수는 몇회인가요?: ");
        String tryCountInput = Console.readLine();
        return Integer.parseInt(tryCountInput);
    }
}
