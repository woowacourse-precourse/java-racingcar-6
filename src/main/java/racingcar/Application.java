package racingcar;

import racingcar.domain.RacingCar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.makeRandomNumber();
        racingCar.goOrStop();
        System.out.println(racingCar.randomNumber + " " + racingCar.distance);
    }
}
