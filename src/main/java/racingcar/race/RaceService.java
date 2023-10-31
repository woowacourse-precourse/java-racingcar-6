package racingcar.race;

import racingcar.car.Car;
import racingcar.variables.ErrorMessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {
    private List<Car> cars;
    private String result = "실행 결과\n";

    public RaceService() {
        this.cars = new ArrayList<>();
    }

    public void initializeCars(String[] carNames) {
        cars = Arrays.stream(carNames)
                .peek(this::checkValidName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public String playRaces(int nTimes) {
        String tmp = "실행 결과\n";
        for (int i = 0; i < nTimes; i++) {
            tmp += calcResult();
        }
        return tmp;
    }

    public String getWinner() {
        int maxCoord = cars.stream()
                .mapToInt(Car::getCoord)
                .max()
                .orElse(0);

        List<String> winnerNames = cars.stream()
                .filter(car -> car.getCoord() == maxCoord)
                .map(Car::getName)
                .collect(Collectors.toList());

        return "최종 우승자 : " + String.join(", ", winnerNames);
    }

    private void checkValidName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_ERROR.getErrorMessage());
        }
    }

    private String calcResult() {
        String tmpres = "";
        for (Car car : cars) {
            car.tryMovingForword();
            tmpres = tmpres + car + "\n";
        }
        return result + tmpres + "\n";
    }
}
