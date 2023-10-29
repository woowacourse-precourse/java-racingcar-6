package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final int MIN_MOVABLE_NUMBER = 4;
    public static final int START_RANGE = 0;
    public static final int END_RANGE = 9;

    String name;
    int location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isMove(){
        if(canGo()){
            this.location++;
            return true;
        }
        return false;
    }

    private boolean canGo() {
        int randomNum = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
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
