package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarUtil {

    public List<Car> parseCarName(String input) {
        List<Car> cars = new ArrayList<>();

        if (input.contains(",")) {
            for (String car : input.split(",")) {
                cars.add(new Car(car));
            }
        } else {
            cars.add(new Car(input));
        }

        return cars;
    }

    public boolean move() {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }

    public void process(Car car) {
        if(move()) {
            car.setProgress(car.getProgress() + "-");
        }
    }

    public String progressCheck(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : cars) {
            if(stringBuilder.isEmpty()) {
                stringBuilder.append(car.getRacingCar());
            } else {
                stringBuilder.append(", ").append(car.getRacingCar());
            }
        }

        return stringBuilder.toString();
    }

    public String winnerCheck(Car car) {
        if(car.getProgress().length() >= 5) {
            return car.getRacingCar();
        }
        return "";
    }

}
