package racingcar.component;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
        cars = new LinkedList<>();
    }

    public List<String> inputNewCarNames() {
        List<String> nameList = new LinkedList<>();

        String names = Console.readLine();
        for (String name : names.split(",")) {
            nameList.add(name);
        }
        return nameList;
    }

    /*
    public void addCarsByNames(List<String> names) {

    }
    */

}
