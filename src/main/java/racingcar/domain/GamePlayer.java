package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/*
 *   플레이어의 정보를 담당
 * */

public class GamePlayer {
    private final List<Car> cars = new ArrayList<>();

    public GamePlayer() {
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void printPlayerCars() {
        System.out.println(this.cars);
    }

    //모든 이름을 리스트로 가져오는 것 중에 이름의 리스트를 클래스로 설정해주는것이 좋은가?
    public List<String> getAllCarNames() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            car.addNameToList(names);
        }
        return names;
    }

    public void moveCarsByCount(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
            System.out.println();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    @Override
    public String toString() {
        return "GamePlayer{" +
                "cars=" + cars +
                '}';
    }
}
