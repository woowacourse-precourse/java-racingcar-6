package racingcar;

public class Car {
    private int score;
    private String name;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getInfo(){
        return String.format("%s : %s",this.name,"-".repeat(this.score));
    }
}
