package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(){
        name ="";
        distance = 0;
    }

    public Car(String name){
        this.name = name;
        distance = 0;
    }

    public void moving(int randomNumber){
        if(randomNumber >= 4){
            distance += 1;
        }
    }

    public int getDistance(){
        return distance;
    }

    public String getName(){
        return name;
    }
}
