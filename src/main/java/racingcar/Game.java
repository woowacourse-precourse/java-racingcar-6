package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Validation.validateCarName;
import static racingcar.Validation.validateDuplicateCar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars;
    private Integer totalMove;

    public void run() throws IllegalArgumentException {
        cars = getCars();
        totalMove = getTotalMove();
        getResult();
    }

    private List<Car> getCars() throws IllegalArgumentException {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> cars = new ArrayList<>();

        for (String carName : readLine().split(",")) {
            validateCarName(carName);
            validateDuplicateCar(cars, carName);

            cars.add(new Car(carName));
        }

        return cars;
    }

    private Integer getTotalMove() {

        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(readLine());
    }

    private void getResult() {

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < totalMove; i++) {
            moveAllCar();
            printRoundProgress();
            System.out.println();
        }

        printWinner();
    }

    private void moveAllCar() {

        for (Car car : cars) {
            car.tryMove();
        }
    }

    private void printRoundProgress() {

        for (Car car : cars) {
            car.printProgress();
        }
    }

    private void printWinner() {

        List<Car> winners = getWinner();

        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);

            result.append(winner.name);
            if (i < winners.size() - 1) {
                result.append(", ");
            }
        }

        System.out.println(result);
    }

    private List<Car> getWinner() {

        List<Car> winners = new ArrayList<>();
        Integer maxScore = 0;

        for (Car car : cars) {
            if (car.location > maxScore) {
                winners.clear();
                winners.add(car);
                maxScore = car.location;
                continue;
            }

            if (car.location.equals(maxScore)) {
                winners.add(car);
            }
        }

        return winners;
    }
}
