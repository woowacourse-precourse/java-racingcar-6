package racingcar.model;

import java.util.ArrayList;

public class ScoreBoard {
    private ArrayList<Car> carList;

    public ScoreBoard(String[] names) {
        this.carList = new ArrayList<>();
        for (String name : names) {
            exceptCarNameValidate(name);
            this.carList.add(new Car(name, 0));
        }
    }

    public ArrayList<String> aggregateScore() {
        ArrayList<String> roundScore = new ArrayList<>();
        for (Car car : this.carList) {
            car.move();
            String carNameScore = car.getCarNameDistance();
            roundScore.add(carNameScore);
        }
        return roundScore;
    }

    public ArrayList<String> aggregateHighScoreCarNames() {
        ArrayList<String> carNameList = new ArrayList<>();
        int highScore = 0;

        for (Car car : this.carList) {
            int carScore = car.getMoveDistance();
            String carName = car.getCarName();
            if (highScore < carScore) {
                carNameList.clear();
                carNameList.add(carName);
                highScore = carScore;
                continue;
            }
            if (highScore == carScore) {
                carNameList.add(carName);
            }
        }

        return carNameList;
    }


    public void exceptCarNameValidate(String carName) {
        if (Validator.validateMaxNameLength(carName)) {
            throw new IllegalArgumentException("입력값이 최대 길이를 초과 했습니다.");
        }
        if (Validator.validateNameIsNull(carName)) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
    }

}
