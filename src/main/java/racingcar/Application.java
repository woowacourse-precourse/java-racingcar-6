package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Race;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = new ArrayList<String>(askCarNames());
        int moveCount = askMoveCount();

        System.out.println("실행 결과");
        Race race = new Race();
        Referee referee = new Referee();

        Map<String, Integer> raceResult = race.racing(carNames, moveCount);

        List<String> winnerNames = referee.winner(raceResult);

        System.out.print("최종 우승자 : ");
        String winner = String.join(", ", winnerNames);
        System.out.print(winner);
    }

    public static List<String> askCarNames() {
        List<String> carNames = new ArrayList<String>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input[] = Console.readLine().replaceAll("\\p{Z}", "").split(",");

        for (String x : input) {
            if (x.length() <= 5) {
                carNames.add(x);
            } else throw new IllegalArgumentException();
        }
        return carNames;
    }

    public static int askMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        try {
            int d = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        int moveCount = Integer.parseInt(input);
        System.out.print("\n");
        return moveCount;
    }
}
