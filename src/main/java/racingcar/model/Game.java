package racingcar.model;


import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Car> cars;
    Integer roundLimit;

    public Game() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        setCars();
        System.out.println("시도할 회수는 몇회인가요?");
        setRoundLimit();
    }

    private void setCars() {
        List<String> carNames = List.of(readLine().split(","));
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
    }

    private void setRoundLimit() throws IllegalArgumentException {
        this.roundLimit = Integer.parseInt(readLine());
        if (this.roundLimit < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void printCurrentPerformance() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMileage()));
        }
        System.out.println();
    }

    @Override
    public void printCurrentPerformance() {

    }

    @Override
    public void printBestPerformers() {

    }
}
