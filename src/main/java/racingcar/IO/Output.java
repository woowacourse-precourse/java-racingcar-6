package racingcar.IO;

import java.util.List;

public class Output {
    public void showResult (String[] names, int[] result) {
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " : " + "-".repeat(result[i]));
        }
    }

    public void showWinners (String[] names, List<Integer> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            if (0 < i) {
                System.out.print(", ");
            }
            System.out.print(names[winners.get(i)]);
        }

    }
}
