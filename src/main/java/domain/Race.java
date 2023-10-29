package domain;

import util.UserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Race {

    private static Race instance = new Race();

    private List<Car> cars;
    private int moveCount;

    private Race() {
        this.cars = new ArrayList<>();
        this.moveCount = 0;
    }

    public static Race getInstance() {
        if (instance == null) {
            instance = new Race();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void start() {
        inputRaceDetails();
        runRace();
        declareWinner();
    }

    private void inputRaceDetails() {
        inputCarNames();
        inputMoveCount();
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = UserInput.inputCarNames();
        initializeCars(carNames);
    }

    private void initializeCars(String[] carNames) {
        Arrays.stream(carNames)
                .map(carName -> {
                    Car car = new Car();
                    car.setName(carName);
                    return car;
                })
                .forEach(cars::add);
    }

    private void inputMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        this.moveCount = UserInput.inputMoveCount();
    }

    private void runRace() {
        System.out.println("실행 결과");

        Stream.iterate(0, n -> n + 1)
                .limit(moveCount)
                .forEach(i -> {
                    cars.stream()
                            .peek(Car::drive)
                            .forEach(Car::printPosition);
                    System.out.println();
                });
    }

    private void declareWinner() {
        String winnerName = checkWinner(cars);
        printWinner(winnerName);
    }

    private String checkWinner(List<Car> cars) {


        return ""
    }

}
