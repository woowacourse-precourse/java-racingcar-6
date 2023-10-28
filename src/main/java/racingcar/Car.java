package racingcar;

import java.util.ArrayList;
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

    static List<Car> makeCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            Car car = new Car(name, new ArrayList<>(), 0, false);
            carList.add(car);
        }

        return carList;
    }
}
