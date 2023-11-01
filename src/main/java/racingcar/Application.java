package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.Referee;


public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Referee referee = new Referee();

        List<String> carNames = askCarNames();

        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = Integer.parseInt(Console.readLine());

        List<Integer> scores = makeScores(carNames.size());
        for (int i = 0; i < attempts; i++) {
            scores = game.movingCars(scores);
            System.out.println(game.getCurrentResult(carNames, scores));
        }

        List<String> winner = referee.getWinner(carNames, scores);
        String finalWinner = "";
        for (int i = 0; i < winner.size(); i++) {
            finalWinner += winner.get(i);
            if (i != winner.size() - 1) {
                finalWinner += ", ";
            }
        }
        System.out.print("최종 우승자 : " + finalWinner);


    }

    public static List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<String> carNames = Arrays.asList(carNamesInput.split(","));

        return carNames;
    }

    public static List<Integer> makeScores(int carCount) {
        Integer[] scoresArray = new Integer[carCount];
        Arrays.fill(scoresArray, 0);
        List<Integer> scores = Arrays.asList(scoresArray);

        return scores;
    }
}
