package racingcar;

import java.util.List;

public class Car {
    private String name;
    private List<String> goOrStopRecord;
    private int totalGoTimes;
    private boolean isWinner;

    public Car(String name, List<String> goOrStopRecord, int totalGoTimes, boolean isWinner) {
        this.name = name;
        this.goOrStopRecord = goOrStopRecord;
        this.totalGoTimes = totalGoTimes;
        this.isWinner = isWinner;
    }

    public String getName() {
        return name;
    }

    public List<String> getGoOrStopRecord() {
        return goOrStopRecord;
    }

    public void setGoOrStopRecord(List<String> goOrStopRecord) {
        this.goOrStopRecord = goOrStopRecord;
    }

    public int getTotalGoTimes() {
        return totalGoTimes;
    }

    public void setTotalGoTimes(int totalGoTimes) {
        this.totalGoTimes = totalGoTimes;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    List<Car> makeCarObject(List<String> carNameList) {
        return null;
    }
}
