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
        for (String name : nameArr)
            gameCar.add(new Car(name));
    }

    public void playGame(String roundsStr) {
        int rounds = parseRounds(roundsStr);

        for (int i = 0; i < rounds; i++) {
            moveCars();
            displayResults();
        }
    }

    public String findWinner() {
        int maxMoveValue = findMaxValue();
        List<String> maxMoveNames = findMaxNames(maxMoveValue);
        return String.join(", ", maxMoveNames);
    }

    private int parseRounds(String roundsStr) {
        try {
            return Integer.parseInt(roundsStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int findMaxValue() {
        return gameCar
                .stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }

    private List<String> findMaxNames(int maxMoveValue) {
        return gameCar
                .stream()
                .filter(car -> car.getMove() == maxMoveValue)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void displayResults() {
        for (Car car : gameCar)
            System.out.println(car.getName() + " : " + "-".repeat(car.getMove()));
        System.out.println("");
    }

    private void moveCars() {
        for (Car car : gameCar)
            if (randomNumber() >= 4)
                car.plusMove();
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public List<Car> getGameCar() {
        return gameCar;
    }
}
