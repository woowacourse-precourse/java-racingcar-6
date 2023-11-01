package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private List<Car> cars;
    private int roundCount;

    public Game() {
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public List<Car> generateCars(String carNamesInput) {

        String[] carNames = carNamesInput.split(",");

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName, 0));
        }
        setCars(carList);
        return carList;
    }

    public int generateRoundCount(String roundCountInput) {
        roundCount = Integer.parseInt(roundCountInput);
        setRoundCount(roundCount);
        return roundCount;
    }

    public void showProcessingBoard(List<Car> cars, int roundCount) {
        System.out.println();
        System.out.println("실행 결과");

        for (int turn = 0; turn < roundCount; turn++) {
            moveCars(cars);
            printCars(cars);
        }
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void showResultBoard(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winnerNames = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    public int getMaxDistance(List<Car> cars) {
        return Objects.requireNonNull(cars.stream()
                        .max(Car::compareTo)
                        .orElse(null))
                .getDistance();
    }

}
