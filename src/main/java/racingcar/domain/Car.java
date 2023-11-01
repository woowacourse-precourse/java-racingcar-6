package racingcar.domain;

public class Car {
    private String name;
    private int score;

    public Car(String name){
        this.name = name;
        this.score = 0;
    }
    public void moveCar(int moveNum){
        if(moveNum >= 4){
            score++;
        }
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
}
