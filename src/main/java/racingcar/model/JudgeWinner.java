package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class JudgeWinner {
    private List<String> winner;

    public JudgeWinner(int[] result, List<String> carMembers) {
        whoIsWinner(result, carMembers);
    }

    public String getWinner() {
        String str = "";

        for (String tmp : winner) {
            str += tmp + ",";
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }

    public void whoIsWinner(int[] result, List<String> carMembers) {
        List<String> winner = new ArrayList<>();
        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) {
                winner.add(carMembers.get(i));
            }
        }
        this.winner = winner;
    }
}
