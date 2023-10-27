package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.domain.AskCarName;
import racingcar.domain.AskHowManyPlayGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AskCarName askCarName = new AskCarName();
        AskHowManyPlayGame askHowManyPlayGame = new AskHowManyPlayGame();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Map<String, Integer> gamePlayer= askCarName.askCarName(Console.readLine());

        System.out.println("시도할 회수는 몇회인가요?");
        int howManyPlayGame = askHowManyPlayGame.askHowManyPlayGame(Console.readLine());
    }
}
