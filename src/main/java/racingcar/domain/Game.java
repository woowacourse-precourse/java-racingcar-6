package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private List<Car> cars;
    private int attempts;

    public Game() {
    }

    private String getCarNames() {
        return Console.readLine();
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    private List<Car> makeCarNameList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(new Car(name));
        }
        return carList;
    }

}
