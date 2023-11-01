package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> userCarList = GameStart.userInput();
        List<String> resultCarList = GameStart.start(userCarList);

        List<String> winnerValue = SearchWinner.winnerSearch(resultCarList);
        List<String> winnerName = NameSplit.splitCarList(winnerValue, " :");
        System.out.println("최종 우승자 : " + String.join(",", winnerName));

    }
}
