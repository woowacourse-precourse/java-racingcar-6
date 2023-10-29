package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int turn;
    public Racing(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public void startRacing() {
        for (int i = 0; i < turn; i++) {
            for (Car car : cars) {
                car.move();
            }
            printTurnResult();
        }
    }

    public List<Car> getWinners() {
        return null;
    }

    private void printTurnResult() {

    }


    public static Racing createRacingWithInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carArr = Console.readLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int turn = Integer.valueOf(Console.readLine());

        List<Car> cars = new ArrayList<>();
        for (String name : carArr) {
            cars.add(new Car(name));
        }

        return new Racing(cars, turn);
    }

    private static void validateCreateRacingInput() {

    }
}
