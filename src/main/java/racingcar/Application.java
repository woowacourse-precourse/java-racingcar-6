package racingcar;

import java.util.List;
import racingcar.domain.NumberManager;
import racingcar.domain.PlayRacing;
import racingcar.domain.RaceSetting;

public class Application {
    public static void main(String[] args) {
        System.out.println(new RaceSetting().regCar());
        System.out.println(new RaceSetting().playNumber());
        System.out.println(new NumberManager().generateRandomNumber());
    }
}
