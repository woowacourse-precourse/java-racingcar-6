package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RacingManager {
    int lap;    // 레이싱 횟수

    public List<String> splitCarName(String carName) {
        return Arrays.stream(carName.split(",")).toList();
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public void race(List<RacingCar> racingCars) {
        for (int i = 0; i < lap; i++) {
            for (RacingCar racingCar : racingCars) {
                System.out.println(racingCar.move(Randoms.pickNumberInRange(0, 9)));
            }
        }
    }

}
