package racingcar.view;

public class OutputMessage {
    public void currentRecord(String car, int now) {
        System.out.println(car + " : " + "-".repeat(now));
    }

    public void finishRecord() {
        System.out.println();
    }
}