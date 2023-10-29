package racingcar.racingGame;

import java.util.List;

public class RacingGame {

    private Gamer gamer;

    public RacingGame() {
        this.gamer = new Gamer();
    }

    public void gameStart() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> carName = gamer.getCarName();

        System.out.println("입력한 자동차 이름 : " + carName.toString());

    }

}
