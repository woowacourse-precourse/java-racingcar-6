package racingcar;

import racingcar.domain.RaceSetting;

public class Application {
    public static void main(String[] args) {
        RaceSetting raceSetting = new RaceSetting();
        System.out.println(raceSetting.regCar());
    }
}
