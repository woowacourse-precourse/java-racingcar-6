package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public final class Util {

    public static List<String> toArray(String cars){
        return Arrays.asList(cars.split(","));
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static int getMaxPosition(List<Car> racingCar) {
        return racingCar.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("무승부입니다!"));
    }
}

