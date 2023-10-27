package racingcar.domain;

public class Car {

    private final String name = getCarName();

    private int position = 0;


    public String getCarName(){
        return name;
    }

    public int getCarPosition(){
        return position;
    }

    public  void moveForward(int distance){
        position += distance;
    }


}
