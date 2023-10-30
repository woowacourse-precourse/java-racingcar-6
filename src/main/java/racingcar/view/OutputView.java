package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final static String resultMessage = "실행 결과";
    private final static String winnerMessage = "최종 우승자";

    public void roundResult(Map<String, List<Integer>> roundMap, int round) {
        StringBuilder sb = new StringBuilder();

        sb.append(resultMessage + "\n");

        for (int i = 0; i < round; i++) {
            for (Map.Entry<String, List<Integer>> car : roundMap.entrySet()) {
                String name = car.getKey();
                Integer move = car.getValue().get(i);

                String dashes = "-".repeat(move);

                sb.append(String.format("%s : %s%n", name, dashes));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public void getWinnerMessage(List<String> winnerList) {
        String winner = winnerMessage + " : " + String.join(", ", winnerList);
        System.out.println(winner);
    }
}
