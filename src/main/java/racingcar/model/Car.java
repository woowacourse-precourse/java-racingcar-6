package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constant;
import racingcar.util.Util;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go(){
        int num = Randoms.pickNumberInRange(0,9);
        if (num>=4){
            position++;
        }
    }
    public String getRoundResult() {
        return name + Constant.ROUND_RESULT_DELIMITER + Util.dashRepeat(position);
    }

    public boolean isWinner(int winDistance){
        return position == winDistance;
    }
}
