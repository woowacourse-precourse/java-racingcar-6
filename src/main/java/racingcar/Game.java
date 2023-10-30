package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static List<Car> cars = new ArrayList<>();
    public static Player player = new Player();

    public void play() {
        askCarNames();
    }

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        player.inputCarNames();
    }
}
