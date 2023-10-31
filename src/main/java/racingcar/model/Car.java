package racingcar.model;

public class Car {
    private String name;
    private int score = 0;
    public Car(String name){
        this.name = name;
    }
    public void score(){
        this.score++;
    }
    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }
}
