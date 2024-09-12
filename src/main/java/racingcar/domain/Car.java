package racingcar.domain;

public class Car {

    private String carName;

    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }


    public String getCarName(){
        return carName;
    }

    public int getCarPosition(){
        return position;
    }

    public  void moveForward(int distance){
        position += distance;
    }


}
