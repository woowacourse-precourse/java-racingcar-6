package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final String SCORE_GRAPH = "-";
    private static final String FIELD = "FIELD";
    private static final int MOVE_POSSIBLE_NUMBER = 4;
    private String carName;
    private String currentLocation;
    private int score;

    Car(String carName, String field) {
        this.carName = carName;
        this.currentLocation = field;
        this.score = 0;
    }

    static public Car attendCar(String carName) {
        return new Car(carName, FIELD);
    }

    public String myCurrentStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(carName).append(" : ").append(SCORE_GRAPH.repeat(score));

        return sb.toString();
    }

    public void roundStart() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= MOVE_POSSIBLE_NUMBER) {
            plusScore();
        }
    }

    private void plusScore() {
        score++;
    }

    public int nowScore() {
        return score;
    }

    public String myName() {
        return carName;
    }

}
