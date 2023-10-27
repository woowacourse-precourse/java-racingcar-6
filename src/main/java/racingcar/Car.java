package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private String name;
    private int location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isMove(){
        int randomNum = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        if(canGo(randomNum)){
            this.location++;
            return true;
        }
        return false;
    }

    private boolean canGo(int randomNum) {
        return randomNum >= MIN_MOVABLE_NUMBER;
    }

    public String getRoundResult(){
        StringBuilder sb = new StringBuilder(name);
        sb.append(" : ");
        for(int i = 0; i<location; i++){
            sb.append("-");
        }

        return sb.toString();
    }
}
