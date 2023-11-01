package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import racingcar.Util.OutputMessage;

public class Game {
    int attempt;
    List<Car> cars;

    public void start() {
        input();

        System.out.println("실행 결과");
        for (int i = 0; i < attempt; i++) {
            race();
        }

        List<String> winnerList = getWinners();
        String winners = String.join(",", winnerList);
        System.out.println("최종 우승자 : " + winners);
    }

    // 자동차는 최소 1대, 자동차 이름은 최소 1글자 ~ 최대 5글자의 알파벳
    void input() {
        System.out.println(Util.OutputMessage.INPUT_CAR_NAMES_MESSAGE.getMessage());
        String inputCarNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputCarNames.split(","));

        sameCarNameValidation(carNames);
        cars = createCar(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputAttempt = Console.readLine();

        attemptValidation(inputAttempt);
        attempt = Integer.parseInt(inputAttempt);

        System.out.println("");
    }

    List<Car> createCar(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    void race() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.run(randomValue);
            distanceOutput(car);
        }
        System.out.println("");
    }

    void distanceOutput(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(car.getName() + " : " + stringBuilder.toString());
    }

    List<String> getWinners() {
        List<String> winnerList = new ArrayList<>();
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        for (Car car : cars) {
            if (maxDistance == car.getDistance()) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    void sameCarNameValidation(List<String> carNames) {
        Set<String> carNameSet = Set.copyOf(carNames);
        if (carNames.size() != carNameSet.size()) {
            throw new IllegalArgumentException(OutputMessage.SAME_CAR_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    void attemptValidation(String inputAttempt) {
        if (!Util.ATTEMPT_PATTERN.matcher(inputAttempt).matches()) {
            throw new IllegalArgumentException(OutputMessage.ATTEMPT_VALUE_ERROR_MESSAGE.getMessage());
        }
    }
}
