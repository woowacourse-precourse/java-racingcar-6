package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomNumberCreator;

public class CarFactory {

    private List<Car> store = new ArrayList<>();

    public void addCar(String name) {
        Car car = new Car(name);
        store.add(car);
    }

    public void updateCarDistance() {
        for (Car car : store) {
            int randomNumber = RandomNumberCreator.makeRandomNumber();
            car.updateDistance(randomNumber);
        }
    }

    public List<Car> getNameAndDistance() {
        // store에 저장된 Car 객체의 이름과 거리를 복사한 새로운 객체를 반환 (원본 Car 객체의 메모리 값을 전달하지 않음)
        return store.stream()
                .map(car -> new Car(car.getName(), car.getDistance()))
                .toList();
    }
}
