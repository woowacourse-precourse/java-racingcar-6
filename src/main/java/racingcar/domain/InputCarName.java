package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputCarName {
    public List<String> createCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carname = new ArrayList<>();
        String car = Console.readLine();
        String[] cars = car.split(",");
        for (int i = 0; i < cars.length; i++) {
            carname.add(cars[i]);
        }
        return carname;
    }
}