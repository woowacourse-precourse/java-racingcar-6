package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {
    List<Car> carList = null;
    int carRacingCount = 0;

    List<String> setCarNameList() {
        String carNames = null;
        List<String> carNameList = null;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Console.readLine();
        return carNameList = Arrays.asList((carNames.split(",")));
    }

    void carNameError(List<String> carNameList) {
        for (String s : carNameList) {
            if (s.length() > 5)
                throw new IllegalArgumentException();
        }
    }

    List<Car> setCarList() {
        int carCount = 0;
        String carNames = null;
        List<String> carNameList = null;
        List<Car> carList = new ArrayList<>();

        carNameList = setCarNameList();
        carNameError(carNameList);
        carCount = carNameList.size();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(carNameList.get(i)));
        }
        return carList;
    }
}
