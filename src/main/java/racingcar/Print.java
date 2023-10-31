package racingcar;

import java.util.HashMap;
import java.util.List;

public class Print {
    public static String progress(List<String> members, HashMap<String, String> membersHM) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < members.size(); i++) {
            sb.append(members.get(i)).append(" : ").append(membersHM.get(members.get(i))).append("\n");
        }

        return sb.toString();
    }

    public static String winner(List<String> winner) {
        StringBuilder sb = new StringBuilder();

        sb.append("최종 우승자 : ").append(String.join(", ", winner));

        return sb.toString();
    }
}
