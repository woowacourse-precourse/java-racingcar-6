package racingcar.view;

import java.util.List;

public class OutputMessage {
    public void currentRecord(String car, int now) {
        System.out.println(car + " : " + "-".repeat(now));
    }

    public void finishRecord() {
        System.out.println();
    }

    public void result(List<String> car, int[] now) {
        StringBuilder result = new StringBuilder("최종 우승자 :");
        for (int i = 0; i < now.length; i++) {
            if (now[i] != 0) {
                result.append(" ");
                result.append(car.get(i));
                result.append(",");
            }
        }
        int tempLength = result.length();
        result.setLength(tempLength - 1);
        System.out.println(result);
    }
}