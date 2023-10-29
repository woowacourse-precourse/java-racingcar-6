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

    public Integer getPosition(){
        return position;
    }

    public void moveForward(){
        this.position++;
    }

    public void printPosition(){
        for(int i = 0; i<position; i++){
            System.out.print("-");
        }
    }
}
