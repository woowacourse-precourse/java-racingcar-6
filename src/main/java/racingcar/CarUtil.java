package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarUtil {

    public List<Car> parseCarName(String input) {
        List<Car> cars = new ArrayList<>();

        if (input.contains(",")) {
            for (String car : input.split(",")) {
                cars.add(new Car(validate(car)));
            }
        } else {
            cars.add(new Car(validate(input)));
        }

        return cars;
    }

    public boolean move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }

    public void process(Car car) {
        if (move()) {
            car.setProgress(car.getProgress() + "-");
        }
    }

    public String validate(String car) {
        if (car.length() <= 5) {
            return car;
        } else {
            throw new IllegalArgumentException(car + "(은)는 이름 형식에 맞지 않습니다.");
        }
    }

}
