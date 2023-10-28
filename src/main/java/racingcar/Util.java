package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import racingcar.Model.Car;

public final class Util {

    private Util(){

    }
    public static ArrayList<String> toArray(String cars){
        return new ArrayList<>(Arrays.asList(cars.split(",")));
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int getMaxPosition(ArrayList<Car> racingCar) {
        return racingCar.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("No cars to compare"));
    }
}

