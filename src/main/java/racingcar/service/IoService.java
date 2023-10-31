package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.carfactory.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IoService {
    IoValidation ioValidation;

    public IoService() {
        ioValidation = new IoValidation();
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        ioValidation.validateCarNameInput(carNames);
        return carNames;
    }

    public int inputTurnNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String turnNumber = Console.readLine();
        ioValidation.validateTurnNumberInput(turnNumber);
        System.out.println(" ");
        return Integer.parseInt(turnNumber);
    }

    public void printOneTurnResult(List<Car> cars) {
        cars.stream().forEach(this::printOneCarLocation);
        System.out.println("");
    }

    private void printOneCarLocation(Car car) {
        System.out.println(String.format("%s : %s",
                car.getName(), "-".repeat(car.getLocation())));
    }

    public void printWinner(List<Car> winners) {
        System.out.println(String.format("최종 우승자 : %s",
                winners.stream()
                        .map(Car::getName)
                        .collect(Collectors.joining(", "))));
    }

}
