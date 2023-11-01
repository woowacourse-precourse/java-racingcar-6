package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.factory.GameFactory;
import racingcar.factory.impl.NamedCarGameFactory;
import racingcar.game.Game;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();

        GameFactory factory = new NamedCarGameFactory(names, count);
        Game game = factory.createGame();
        game.play();
    }
}
