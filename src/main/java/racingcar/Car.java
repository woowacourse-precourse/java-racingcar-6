package racingcar;

public class Car {
    static int count = 0;

    String carName = "";
    int advanceCount = 0;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String name) {
        carName = name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void setAdvanceCount(int num) {
        if(num >= 4)
            advanceCount++;
    }
}

