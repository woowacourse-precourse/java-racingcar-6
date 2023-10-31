package racingcar.model;


import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private void printBestPerformers() {
        descSortCarsByMileage();
        int max = cars.get(0).getMileage();

        String res = cars.get(0).getName();
        for (int i = 1; i < cars.size(); ++i) {
            Car car = cars.get(i);
            if (car.getMileage() >= max) {
                res = res.concat(", " + car.getName());
            }
        }
        System.out.println(res);
    }

    private void descSortCarsByMileage() {
        cars.sort((o1, o2) -> {
            if (o1.getMileage() < o2.getMileage()) {
                return 1;
            } else if (Objects.equals(o1.getMileage(), o2.getMileage())) {
                return 0;
            }
            return -1;
        });
    }

    public void run() {
        System.out.println("\n실행 결과");
        for (int round = 0; round < roundLimit; ++round) {
            runEachRound();
            printCurrentPerformance();
        }
        System.out.print("최종 우승자 : ");
        printBestPerformers();
    }

    private void runEachRound() {
        for (Car car : cars) {
            car.goForward();
        }
    }
}
