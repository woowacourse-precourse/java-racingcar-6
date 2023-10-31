package racingcar.model;

import java.util.ArrayList;

public class GameModel {
    private ArrayList<Car> scoreBoard;
    private int raceTimes;

    public GameModel(String inputNames, String inputTimes) {

        String[] names = inputNames.split(",");

        this.scoreBoard = new ArrayList<>();
        for (String name : names) {
            String nameNoSpace = name.trim();
            this.scoreBoard.add(new Car(nameNoSpace, 0));
        }
        this.raceTimes = Integer.parseInt(inputTimes);
    }

    public ArrayList<CarData> aggregateRoundScore() {
        ArrayList<CarData> roundScore = new ArrayList<>();
        for (Car car : this.scoreBoard) {
            car.move();
            CarData roundData = car.getData();
            roundScore.add(roundData);
        }
        return roundScore;
    }

    public ArrayList<String> aggregateHighScore() {
        ArrayList<String> carNameList = new ArrayList<>();
        int highScore = 0;

        for (Car car : this.scoreBoard) {
            CarData carData = car.getData();

            if (highScore < carData.getMoveDistance()) {
                carNameList.clear();
                carNameList.add(carData.getName());
                highScore = carData.getMoveDistance();
                continue;
            }

            if (highScore == carData.getMoveDistance()) {
                carNameList.add(carData.getName());
            }
        }
        return carNameList;
    }


    public boolean raceTimeRemain() {
        return this.raceTimes-- > 0;
    }


}
