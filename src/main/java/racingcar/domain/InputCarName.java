package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputCarName {
    public List<String> createCar() {
        List<String> carname = new ArrayList<>();
        String car = Console.readLine();
        String[] cars = car.split(",");
        for (int i = 0; i < cars.length; i++) {
            carname.add(cars[i]);
        }
        return carname;
    }
}
