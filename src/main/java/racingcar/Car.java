package racingcar;

public class Car {
    private final String name;
    private int score; // 이동 누적 거리 == 점수

    Car(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    int getScore(){
        return this.score;
    }
}
