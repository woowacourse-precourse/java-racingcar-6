package racingcar.domain;

public class Car {
    private String car_name;
    private int car_move;

    public Car(String car_name){
        this.car_name = car_name;
    }
    public void addMove(){
        car_move+=1;
    }
    public String getName(){
        return car_name;
    }
    public int getMove(){
        return car_move;
    }
}
