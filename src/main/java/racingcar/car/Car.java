package racingcar.car;

import racingcar.Constants;
import racingcar.Util;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    // 라운드 실행
    public void go(){
        if (Util.getRandomNum() >= Constants.GO_NUM) {
            position++;
        }
    }

    public String getRoundResult(){
        return name + Constants.ROUND_RESULT_DELIMETER + Util.printScore(position);
    }

    public boolean getWinner(int maxDist){
        return (position == maxDist);
    }
}
