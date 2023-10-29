package racingcar.racingGame;

import java.util.List;

public class RacingGame {

    private Gamer gamer;
    private Car car;

    public RacingGame() {
        this.gamer = new Gamer();
    }

    public void gameStart() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carName = gamer.getCarName();
        System.out.println("입력한 자동차 이름 : " + carName.toString());

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = gamer.getTryNum();
        System.out.println("시도 횟수 : " + tryNum);

    }

}
