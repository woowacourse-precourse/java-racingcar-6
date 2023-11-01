package racingcar.model;

public class Car {
    private String name;
    private Integer position;

    public Car(){
        this.position = 0;
    }

    public Car(String name){
        this();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Integer getPosition(){
        return position;
    }

    public void move(int diff){
        this.position+=diff;
    }
}
