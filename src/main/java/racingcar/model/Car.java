package racingcar.model;

public class Car {
    private String name;
    private Integer position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return name;
    }
}
