package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinnerPrinter {

    public void finalWinner(HashMap<String, Integer> userScore) {
        int max = maxNumber(userScore);

        List<String> userNames = new ArrayList<>();
        for (String userName : userScore.keySet()) {
            if (userScore.get(userName) == max) {
                userNames.add(userName);
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", userNames));
    }

    public int maxNumber(HashMap<String, Integer> userScore) {
        int max = 0;
        for (String userName : userScore.keySet()) {
            if (userScore.get(userName) > max) {
                max = userScore.get(userName);
            }
        }
        return max;
    }

}
