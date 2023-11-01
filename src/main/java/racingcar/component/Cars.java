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

    public void initCars() {
        List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = inputNewCarNames();
        addCarsByNames(names);
    }
}
