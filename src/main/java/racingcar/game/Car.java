package racingcar.game;

public class Car {
    private String name;
    private Integer score;

    public Car(String name){
        this.name = name;
        this.score = 0;
    }

    public void moveForward(){
        // TODO: 상수 선언
        this.score += 1;
    }

    public void stop(){
        // TODO: 상수 선언
        this.score += 0;
    }
}
