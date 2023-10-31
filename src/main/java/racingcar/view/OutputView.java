package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printRecord(Map<Integer, List<String>> record) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n실행 결과\n");

        for(int i = 1; i <= record.size(); i++) {
            List<String> roundRecord = record.get(i);
            roundRecord.forEach((carRecord) -> sb.append(carRecord).append("\n"));

            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void printWinner(List<String> carList) {
        System.out.println("최종 우승자 : " + String.join(", ", carList));
    }
}
