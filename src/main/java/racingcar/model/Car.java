package racingcar.model;
import racingcar.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;


public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        if (name==null || name.length() > Constants.CAR_MAX_NAME_LENGTH){
            throw new IllegalArgumentException(Constants.CAR_NAME_EXCEED_ERROR_MSG);
        }
        this.name = name;
    }
    public void move(){
        if (Randoms.pickNumberInRange(Constants.RANDOM_START, Constants.RANDOM_END) >= Constants.MOVE_THRESHOLD){
            position ++;
        }
    }
    public int getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }

}