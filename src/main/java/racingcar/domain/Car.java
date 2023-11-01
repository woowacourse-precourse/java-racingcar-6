package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int score;
    public Car(String carName) {
        this.name = carName;
        this.score = 0;
    }

    private Car() {
    }

    public void goForward(){
        int number = Randoms.pickNumberInRange(0,9);
        if(number>3){
            score++;
        }
    }

    public String printResult(){
        return name+" : "+"-".repeat(score);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }





}
