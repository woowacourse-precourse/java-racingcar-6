package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<String> goOrStopRecord;
    private int totalGoTimes;

    public Car(String name, List<String> goOrStopRecord, int totalGoTimes) {
        this.name = name;
        this.goOrStopRecord = goOrStopRecord;
        this.totalGoTimes = totalGoTimes;
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

    static List<Car> makeCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            Car car = new Car(name, new ArrayList<>(), 0);
            carList.add(car);
        }
        return carList;
    }
}
