package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        game.addCarList(Console.readLine().split(","));
        System.out.println("시도할 회수는 몇회인가요?");
        game.setMoveCount(Integer.parseInt(Console.readLine()));
        game.showResult();
        game.showWinners();
    }
}
