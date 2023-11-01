package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public static String userCarNameInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = Console.readLine();

        // 자동차 이름이 5자 이상일 경우 IllegalArgumentException
        String[] carNameArray = carNameString.split(",");
        for (String carName : carNameArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
            }
        }

        return carNameString;
    }

    public static String userRaceCountInput() {

        System.out.println("시도할 회수는 몇회인가요?");

        return Console.readLine();
    }
}
