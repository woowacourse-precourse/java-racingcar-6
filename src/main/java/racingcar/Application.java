package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Leaderboard;
import racingcar.domain.NamesManager;
import racingcar.domain.RoundNumberManager;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        NamesManager namesManager = new NamesManager();
        List<String> namesList = namesManager.separateNamesString(Console.readLine());

        namesManager.checkNamesException(namesList);

        Leaderboard leaderboard = new Leaderboard(namesList);

        System.out.println("시도할 회수는 몇회인가요?");
        RoundNumberManager roundNumberManager = new RoundNumberManager();
        String roundNumberString = Console.readLine();

        roundNumberManager.checkRoundNumberExceptions(roundNumberString);

        int roundNumber = Integer.parseInt(roundNumberString);

        System.out.print("\n실행 결과\n");
        while (roundNumber > 0) {
            leaderboard.round();
            leaderboard.status();
            roundNumber--;
        }

        leaderboard.winner();
    }

}
