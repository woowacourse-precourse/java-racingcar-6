package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void start() {
        List<Car> cars = this.giveCars();
        int count = this.giveCount();
        this.play(cars, count);
        this.result(cars);
    }

    private List<Car> giveCars() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String nameInput = Console.readLine();
        String[] carNames = nameInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int giveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void play(List<Car> cars, int count) {
        System.out.print("\n");
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.run();
            }
            System.out.print("\n");
        }
    }

    private void result(List<Car> cars) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", Car.giveWinner(cars)));
    }
}
