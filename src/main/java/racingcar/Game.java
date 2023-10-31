package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars;
    private Integer totalMove;

    public void run() {
        cars = getCars();
        totalMove = getTotalMove();
        getResult();
    }

    private List<Car> getCars() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> cars = new ArrayList<>();

        for (String carName : readLine().split(",")) {
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
            /// TODO : Car Move
            System.out.println("Each Car Tries To Move");
        }
    }

    private void printRoundProgress() {

        for (Car car : cars) {
            /// TODO : Print Car Location
            System.out.println("Each Car Prints Its Location");
        }
    }

    private void printWinner() {

        List<Car> winners = getWinner();

        for (Car winner : winners) {
            /// TODO : Print Car isWinner
            System.out.println("Print Winner Name");
        }
    }

    private List<Car> getWinner() {

        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            /// TODO : Add Car If It isWinner
            System.out.println("Add Car If It isWinner");
        }
        return winners;
    }
}
