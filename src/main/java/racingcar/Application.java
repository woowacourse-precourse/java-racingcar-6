package racingcar;

import racingcar.domain.AskPlayer;
import racingcar.domain.Cars;
import racingcar.domain.Generator;

public class Application {
    public static void main(String[] args) {
        Generator g = new Generator();
        System.out.println(g.generateRandomNum());
    }
}
