package racingcar;

public class DriveCar {
    String name;
    int score;

    DriveCar(String name, int score){
        this.name = name;
        this.score = score;
    }

    void setName(String name){
        this.name = name;
    }

    void setScore(int score){
        this.score = score;
    }

    String getName(){
        return this.name;
    }

    int getScore(){
        return this.score;
    }
}
