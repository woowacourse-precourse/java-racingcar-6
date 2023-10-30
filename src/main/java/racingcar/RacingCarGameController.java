package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGameController {

    private static String DELIMITER = ",";

    private RacingCarGame racingCarGame;

    public void gameInit() {
        String userInput = receiveCarNames();
        String[] carNames = userInput.split(DELIMITER);
        checkCarNamesLength(carNames);
    }

    private static String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)");
        return Console.readLine();
    }

    static void checkCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }
}
