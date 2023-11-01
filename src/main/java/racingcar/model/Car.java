package racingcar.model;

import static racingcar.util.Constants.MAX_NAME_SIZE;
import static racingcar.util.Constants.MIN_NAME_SIZE;

public class Car {
    // 전진 후진
    String name;
    int forward = 0;
    int stop = 0;

    public void increaseForward(){
        forward++;
    }

    public void increaseStop(){
        stop++;
    }

    public void printForward(){
        System.out.println(name + " : " + "-".repeat(forward));
    }

    public void randomForward(int random){
        if(random >= 4){
            increaseForward();
        }
    }

    public void createCar(String name){
        validateSize(name);
        this.name = name;
    }

    private void validateSize(String name){
        if(name.length() > MAX_NAME_SIZE || name.length() < MIN_NAME_SIZE){
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public String getName(){
        return name;
    }
    public int getForward(){
        return forward;
    }
    public int getStop(){
        return stop;
    }
}
