package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarInformation {
    public final String name;
    public int position = 0;

    public CarInformation(String name){
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자여야 합니다.");
        }
        this.name = name;
    }

    public void move(){
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
