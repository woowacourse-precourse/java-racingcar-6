package racingcar.model;

public class Car {
    private final String name;
    private int score;

    public Car(String name){
        this.name = name;
        this.score = 0;
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public void increaseScore() {
        this.score++;
    }
}
