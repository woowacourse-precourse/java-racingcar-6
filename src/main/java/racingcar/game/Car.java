package racingcar.game;

public class Car {
    private String name;
    private int moving;

    public Car(){
        this.name = "";
        this.moving = 0;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void addMoving(){
        this.moving++;
    }

    public String getName(){
        return this.name;
    }

    public int getMoving(){
        return this.moving;
    }
}
