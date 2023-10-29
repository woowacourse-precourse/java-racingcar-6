package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> gameCar;

    public Race(String nameStr) {
        gameCar = new ArrayList<>();
        String[] nameArr = nameStr.split(",");
        for (String name : nameArr) {
            gameCar.add(new Car(name));
        }
    }

    public void playGame(String roundsStr) {
        try {
            int rounds = Integer.parseInt(roundsStr);
            if (rounds < 0) {
                throw new IllegalArgumentException("-1보다 큰 수를 입력하세요");
            }

            for (int i = 0; i < rounds; i++) {
                moveCars();
                displayResults();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public String findWinnerToString() {
        int maxValue = findMaxValue();
        List<String> maxMoveNames = findNamesByLength(maxValue);
        return String.join(", ", maxMoveNames);
    }

    private int findMaxValue() {
        return gameCar
                .stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }

    private List<String> findNamesByLength(int maxMoveValue) {
        return gameCar
                .stream()
                .filter(car -> car.getMove() == maxMoveValue)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void displayResults() {
        for (Car car : gameCar) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMove()));
        }
        System.out.println("");
    }

    private void moveCars() {
        for (Car car : gameCar) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.plusMove();
            }
        }
    }

    public List<Car> getGameCar() {
        return gameCar;
    }
}
