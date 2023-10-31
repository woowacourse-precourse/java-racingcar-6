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

    public ArrayList<CarData> aggregateScore() {
        ArrayList<CarData> roundScore = new ArrayList<>();
        for (Car car : this.carList) {
            car.move();
            CarData roundData = car.getData();
            roundScore.add(roundData);
        }
        return roundScore;
    }

    public ArrayList<String> aggregateHighScoreCarNames() {
        ArrayList<String> carNameList = new ArrayList<>();
        int highScore = 0;

        for (Car car : this.carList) {
            CarData carData = car.getData();
            
            Integer carScore = carData.getMoveDistance();
            String carName = carData.getName();

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
