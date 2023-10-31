package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    public void execute() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameArr = getCarName();
    }

    public String[] getCarName() {
        String[] carNameArr = Console.readLine().split(",");
        for (String carName : carNameArr) {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException();
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNameArr;
}
