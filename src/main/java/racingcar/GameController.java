package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void start() {
        List<Car> cars = inputCarNames();
        CarManager carManager = new CarManager(cars);
        int attempt = inputAttempt();
        attempt(carManager, attempt);
        List<Car> winner = winner(carManager);
        printWinner(winner);
    }

    public void attempt(CarManager carList, int attempt) {
        System.out.println("실행 결과");
        carList.attempt(attempt);
    }

    public int inputAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return  Integer.parseInt(Console.readLine());
    }

    public List<Car> inputCarNames() {
        List<Car> cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames =  Console.readLine().split(",");
        for (String name : carNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    public List<Car> winner(CarManager carList) {
        int max = carList.maxPosition();
        return carList.winner(max);
    }

    private void printWinner(List<Car> winner) {
        System.out.print("최종 우승자 : ");
        for (Car car : winner) {
            System.out.print(car.getName());
            if (winner.indexOf(car) != winner.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
