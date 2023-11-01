package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.Car.Car;
import racingcar.game.Car.CarFactory;
import racingcar.utils.UserInputReceiver;
import racingcar.view.View;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static void run() {
        List<Car> cars = createCarsByInput();
        int turnCount = turnCountByInput();
        for (; turnCount > 0; turnCount--) {
            play(cars);
            createTurnResultView(cars).print();
        }
        createFinalResultView(cars).print();
    }

    private static List<Car> createCarsByInput() {
        String message = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
        List<String> carNames = Arrays.asList(UserInputReceiver.messageToUser(message).split(","));
        return CarFactory.createByNames(carNames);
    }

    private static int turnCountByInput() {
        String message = "시도할 회수는 몇회인가요?";
        String turnCount = UserInputReceiver.messageToUser(message);
        try {
            return Integer.parseInt(turnCount);
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Car> play(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    car.moveByRandomNumber(Randoms.pickNumberInRange(0, 9));
                    return car;
                })
                .collect(Collectors.toList());
    }

    private static View createTurnResultView(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getName());
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(car.getMoveDistance()));
            stringBuilder.append("\n");
        }
        return new View(stringBuilder.toString());
    }

    private static View createFinalResultView(List<Car> cars) {
        int maxDistance = cars.stream()
                .map(Car::getMoveDistance)
                .max(Comparator.naturalOrder())
                .orElse(0);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        cars.stream()
                .filter(car -> car.getMoveDistance() == maxDistance)
                        .forEach(car -> stringBuilder.append(car.getName()));

        return new View(stringBuilder.toString());
    }
}
