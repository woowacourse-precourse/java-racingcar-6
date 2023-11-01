package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;
import java.util.ArrayList;

public class Racing {
    public static void turnPlaying (ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (randomResult()) {
                Car car = cars.get(i);
                car.score = car.score.add(BigInteger.ONE);
                cars.set(i, car);
            }
        }
    }

    public static boolean randomResult () {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static StringBuilder calculateWinner (ArrayList<Car> cars) {
        StringBuilder sb = new StringBuilder();
        int i = 1;

        sb.append(cars.get(0).name);
        BigInteger topValue = cars.get(0).score;

        while (i < cars.size() && cars.get(i).score.compareTo(topValue) == 0) {
            sb.append(", ").append(cars.get(i).name);
            i++;
        }

        return sb;
    }
}