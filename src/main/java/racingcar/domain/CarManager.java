package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private static final int MAX_CAR_COUNT = 5;
    private List<Car> cars;
    public void makeCar() {
        printMakeCarMessage();
        cars = createCars(inputCarName());
    }

    private List<Car> createCars(String[] carNameList) {
        return Arrays.stream(carNameList).map(name -> new Car(name.trim())).collect(Collectors.toList());
    }

    private void printMakeCarMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String[] inputCarName() {
        return Console.readLine()
                .split(",");
    }

    public void move() {

    }

    public void showResult() {

    }
}
