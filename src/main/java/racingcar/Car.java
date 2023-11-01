package racingcar;

public class Car{
    private String name;
    public int position =0;

    public Car(String name){
        this.name=name;
    }

    public String getCarName(){
        return name;
    }

    public int getCarPosition(){
        return position;
    }
}
