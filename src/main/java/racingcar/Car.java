package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private StringBuilder progress;

    public Car(String name) {
        this.name = name;
        progress = new StringBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getProgress() {
        return this.progress.toString();
    }

    public void setProgress(){
        this.progress.append("-");
    }

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

}
