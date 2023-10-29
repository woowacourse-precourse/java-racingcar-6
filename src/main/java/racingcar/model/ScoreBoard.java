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
            String score = car.getCarNameDistance();
            roundScore.add(score);
        }
        return roundScore;
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
