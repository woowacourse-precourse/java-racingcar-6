package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarRacing {
    int attempCount;
    List<Car> cars;

    CarRacing() {
        this.attempCount = 0;
        this.cars = new ArrayList<Car>();
    }

    void setCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    boolean isValidCarNames(String[] carNames) {
        int carNamesLength = carNames.length;
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("이름은 1자 이상 5자 이하가 되어야 합니다.");
            }
        }

        if (carNamesLength < 2) {
            throw new IllegalArgumentException("참여 자동차가 2개 이상이어야 합니다.");
        }

        HashSet<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (!carNameSet.add(carName)) {
                throw new IllegalArgumentException("같은 이름이 두개 이상 있습니다.");
            }
        }

        return true;
    }

    void execute() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] carNames = (Console.readLine()).split(",");
        if (isValidCarNames(carNames)) {
            setCars(carNames);
        }

    }
}
