package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;
    public Race(String[] carNames){ // 자동차 객체마다 생성 이를 위해 Car.java 코드 구현

        this.cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveCars(String carNames){ // 자동차 랜덤 이동 함수

        for (Car car : cars) {

            if (car.getName().equals(carNames)) {
                car.move(Randoms.pickNumberInRange(0, 9));
                break;
            }
        }
    }

    public List<Car> getCars(){
        return cars;
    }
}
