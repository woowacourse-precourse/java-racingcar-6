package racingcar;

public class Car {
    private String name;
    private Integer score = 0;

    public Car(String name) {
        this.name = name;
    }

    public void upScore() {
        score += 1;
    }

    @Override
    public String toString() {

        String scoreBoard = "";

        for(int i=0; i<score; i++) {
            scoreBoard += "-";
        }

        return name + " : " + scoreBoard;
    }
}
