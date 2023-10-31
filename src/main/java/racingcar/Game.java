package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars;
    private int rounds;

    Game(List<String> carNames, int rounds) {
        this.cars = getCars(carNames);
        this.rounds = rounds;
    }

    private List<Car> getCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }

        return cars;
    }

    public void play() {
        System.out.println("실행결과");
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < cars.size(); j++) {
                Car car = cars.get(j);
                car.move();
                car.show();
            }
            System.out.println();
        }

        List<String> winners = getWinners();
        String result = String.join(", ", winners);
        System.out.print("최종 우승자 : " + result);
    }

    public List<String> getWinners() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAt(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
