package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RaceSetting {

    public List<String> regCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        String[] carList = splitCars(cars);
        return Arrays.asList(carList);
    }

    public String[] splitCars(String cars) {
        return cars.split(",");
    }

    public int playNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        return StringToNumber(input);
    }

    public int StringToNumber(String input) {
        return Integer.parseInt(input);
    }
}
