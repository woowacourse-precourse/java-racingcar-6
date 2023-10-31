package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
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

    public void generateCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();
        validateCarNames(carNamesInput);
        String[] carNames = carNamesInput.split(",");

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName, 0));
        }
        setCars(carList);
    }

    public void validateCarNames(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void generateRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String roundCountInput = readLine();
        validateRoundCount(roundCountInput);
        setRoundCount(Integer.parseInt(roundCountInput));
    }

    public void validateRoundCount(String roundCountInput) {
        for (int index = 0; index < roundCountInput.length(); index++) {
            validateRoundCountCharacter(roundCountInput.charAt(index));
        }
    }

    public void validateRoundCountCharacter(char characterAtRoundCountInput) {
        if (!Character.isDigit(characterAtRoundCountInput)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public void showProcessingBoard() {
        System.out.println();
        System.out.println("실행 결과");

        for (int turn = 0; turn < getRoundCount(); turn++) {
            moveCars();
            printCars();
        }
    }

    public void moveCars() {
        for (Car car : getCars()) {
            int randomNumber = pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void printCars() {
        for (Car car : getCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void showResultBoard() {
        int maxDistance = getMaxDistance();
        List<String> winnerNames = getCars().stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    public int getMaxDistance() {
        return Objects.requireNonNull(getCars().stream()
                        .max(Car::compareTo)
                        .orElse(null))
                .getDistance();
    }

}
