package racingcar.model;

public class Car {
    private String name;
    private int point;

    public Car(String name){
        this.name = name;
        this.point = 0;
    }

    public String getName(){
        return name;
    }
    public int getPoint(){
        return point;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPoint(int point){
        this.point = point;
    }

    public void upPoint(){
        this.point++;
    }
}
