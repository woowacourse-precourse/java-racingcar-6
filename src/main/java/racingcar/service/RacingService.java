package racingcar.service;

import static racingcar.validation.Validation.inputCarNameValidate;
import static racingcar.validation.Validation.inputRacingTimeValidate;
import static racingcar.view.InputView.inputCarNameMessage;
import static racingcar.view.InputView.inputRacingTimeMessage;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingService {
    private List<String> carName;
    private int racingTime;
    private final List<Car> cars = new ArrayList<>();

    private int maxDistance = 0;
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RACING_RESULT = "\n실행 결과";
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int CAN_MOVE_NUMBER = 4;

    public final void inputCarName() {
        inputCarNameMessage();
        this.carName = divideCarName(Console.readLine());
    }

    private static List<String> divideCarName(String carNames) {
        List<String> carName = Arrays.stream(carNames.split(","))
                .toList();
        inputCarNameValidate(carName);
        return carName;
    }

    public final void inputRacingTime() {
        inputRacingTimeMessage();
        String inputTime = Console.readLine();
        inputRacingTimeValidate(inputTime);
        this.racingTime = Integer.parseInt(inputTime);
    }

    public final void makeCar() {
        for (String name : carName) {
            this.cars.add(new Car(name));
        }
    }

    public final void racing() {
        System.out.println(RACING_RESULT);
        for (int i = 0; i < racingTime; i++) {
            moveCar();
        }
        System.out.println();
    }

    private void moveCar() {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
            car.position();
            maxDistance = car.checkMaxDistance(maxDistance);
        }
        System.out.println();
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE) >= CAN_MOVE_NUMBER;
    }

    public final void printWinner() {
        List<String> winner = cars.stream()
                .filter(car -> car.compareMaxDistance(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(WINNER_MESSAGE + String.join(", ", winner));
    }

}
