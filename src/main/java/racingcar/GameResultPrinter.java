package racingcar;

import java.util.HashMap;

public class GameResultPrinter {

    public void printResult(HashMap<String, Integer> userScore) {

        for (String userName : userScore.keySet()) {
            printUser(userName, userScore.get(userName));
        }
        System.out.println();
    }

    public void printUser(String userName, int userScore) {
        System.out.print(userName + " : ");
        for (int i = 0; i < userScore; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
