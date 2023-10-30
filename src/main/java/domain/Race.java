package domain;

import util.UserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    private void addCar(Car car) {
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
            .map(Car::new)
            .forEach(cars::add);
    }

    private void inputMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        moveCount = UserInput.inputMoveCount();
    }

    private void runRace() {
        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) {
            moveCars();
            printCarsPosition();
            System.out.println();
        }
    }

    private void moveCars() {
        cars.forEach(Car::drive);
    }

    private void printCarsPosition() {
        cars.forEach(Car::printPosition);
    }

    private void declareWinner() {
        String winnerName = checkWinner(cars);
        printWinner(winnerName);
    }

    private String checkWinner(List<Car> cars) {
        int maxPosition = maxPosition(cars);
        List<Car> winners = getWinners(cars, maxPosition);
        return convertListToString(winners);
    }

    private int maxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    private List<Car> getWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private String convertListToString(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private void printWinner(String winnersName) {
        System.out.println("최종 우승자 : " + winnersName);
    }

}
