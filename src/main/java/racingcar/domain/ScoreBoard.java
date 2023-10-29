package racingcar.domain;

public class ScoreBoard {

    public String getCarPosition(Car car) {
        String carPosition = "";
        for (int i = 0; i < car.carPosition; i++) {
            carPosition += "-";
        }
        return carPosition;
    }
}
