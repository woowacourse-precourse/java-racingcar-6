package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class RacingGame {

    String[] names;
    int num;
    private ArrayList<Car> cars, winners;

    public RacingGame() {
        progress();
    }

    private void progress() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        inputName();
        createCar();

        System.out.println("시도할 회수는 몇회인가요?");
        inputNumber();

        System.out.println("\n실행 결과");

        runGame();

        findGamewinner();
    }

    private void inputName() {
        String[] names = Console.readLine().split(",");
        //검사-자동차 수가 2개보다 작으면 예외처리
        if (names.length <= 1) {
            throw new IllegalArgumentException();
        }

        this.names = names;
    }

    private void inputNumber() {
        int num;
        try {
            //검사
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
        this.num = num;
    }

    private void createCar() {
        cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void runGame() {
        for (int i = 0; i < num; i++) {
            moveCar();
            printResult();
        }
    }

    private void printResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void moveCar() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void findGamewinner() {

        winners = new ArrayList<>();
        int maxPos = 0;
        int carPos = 0;

        for (Car car : cars) {
            carPos = car.getPosition();
            if (carPos > maxPos) {
                maxPos = carPos;
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPos) {
                winners.add(car);
            }
        }

        printGameWinner();

    }

    private void printGameWinner() {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
