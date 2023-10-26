package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Position {
    public int position;
    private static final int FORWARD_THRESHOLD=4;
    private static final String SLASH="-";
    public static final int VALUE_LOW_BOUND=0;
    public static final int VALUE_HIGH_BOUND=9;

    public Position(){
        position=0;
    }

    public Position(int status){
        position=status;
    }

    public void attemptForward(){
        if(checkValueIsOverFour(makeRandomValue())){
            moveForward();
        }
    }

    public int makeRandomValue(){
        return Randoms.pickNumberInRange(VALUE_LOW_BOUND,VALUE_HIGH_BOUND);
    }

    public boolean checkValueIsOverFour(int value){
        return value>=FORWARD_THRESHOLD;
    }

    public void moveForward(){
        position+=1;
    }

    public String switchPositionToSlash(){
        return SLASH.repeat(position);
    }
}
