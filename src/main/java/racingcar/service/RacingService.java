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

    private List<String> winner;
    private int maxDistance = 0;

    public void inputCarName() {
        inputCarNameMessage();
        this.carName = divideCarName(Console.readLine());
    }

    private static List<String> divideCarName(String carNames) {
        List<String> carName = Arrays.stream(carNames.split(","))
                .toList();
        inputCarNameValidate(carName);
        return carName;
    }

    public void inputRacingTime() {
        inputRacingTimeMessage();
        String inputTime = Console.readLine();
        inputRacingTimeValidate(inputTime);
        this.racingTime = Integer.parseInt(inputTime);
    }

    public void makeCar() {
        for(String name: carName) {
            this.cars.add(new Car(name));
        }
    }

    public void racing() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < racingTime; i++) {
            moveCar();
        }
        System.out.println();
    }

    private void moveCar() {
        for (Car car: cars) {
            if (canMove()) {
                car.move();
            }
            car.position();
            maxDistance = car.checkMaxDistance(maxDistance);
        }
        System.out.println();
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }

    public void winner() {
       winner = cars.stream()
               .filter(car -> car.compareMaxDistance(maxDistance))
               .map(Car::getName)
               .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

}
