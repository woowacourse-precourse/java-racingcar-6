package racingcar;

public class Car {
    private String name;
    private String moved="";
    public Car(String car_name){
        name= car_name;
    }
    public void push_forward(){
        moved+="-";
    }
    public int get_distance(){
        return moved.length();
    }

    public String get_name(){
        return name;
    }
    public String get_state(){
        return moved;
    }
}
