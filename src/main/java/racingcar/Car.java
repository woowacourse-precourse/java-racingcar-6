package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String distance = "";
    private int distanceNum = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void decideGo(int randomNum) {
        if (randomNum >= 4) {
            plusDistance();
        }
    }

    public int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void plusDistance() {
        distance += "-";
    }

    public int changeDistanceToInt() {
        if (distance != null) {
            distanceNum = distance.length();
        }
        return distanceNum;
    }

    public void printResult() {
        System.out.println(name + " : " + distance);
    }
}