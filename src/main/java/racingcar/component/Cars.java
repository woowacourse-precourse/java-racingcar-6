package racingcar.component;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new LinkedList<>();
    }

    private List<String> inputNewCarNames() {
        List<String> nameList = new LinkedList<>();

        String names = Console.readLine();
        for (String name : names.split(",")) {
            nameList.add(name);
        }
        return nameList;
    }


    private void addCarsByNames(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }


}
