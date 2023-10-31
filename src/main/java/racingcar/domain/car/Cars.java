package racingcar.domain.car;

import static racingcar.view.output.Output.printResultMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.input.error.InputError;
import racingcar.view.input.error.InputIllegalArgumentException;
import racingcar.view.output.OutputMessage;

public class Cars {

    private static final String CARS_ARE_EMPTY = "차가 존재하지 않습니다.";
    private static final int MAXIMUM_FORWARD_NUMBER = 4;

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        validateNameEmpty(carNames);
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private void validateNameEmpty(List<String> names) {
        if (names.size() <= 1) {
            throw new InputIllegalArgumentException(InputError.NOT_EXCEED_MINIMUM_AMOUNT);
        }
    }

    public List<String> findWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(CARS_ARE_EMPTY));

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public void randomCarMove() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            if (isCanForward(randomNumberGenerator.generateRandomNumber())) {
                car.moveCar();
            }
            printResultMessage(OutputMessage.PROGRESS_RESULT, car.getCarName(), car.getDistance());
        }
    }

    private boolean isCanForward(int forwardNumber) {
        return MAXIMUM_FORWARD_NUMBER <= forwardNumber;
    }
}
