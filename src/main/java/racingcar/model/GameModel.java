package racingcar.model;

import java.util.ArrayList;

public class GameModel {
    private ArrayList<Car> scoreBoard;
    private int raceTimes;

    public GameModel(String inputNames, String inputTimes) {

        String[] names = inputNames.split(",");

        this.scoreBoard = initScoreBoard(names);
        this.raceTimes = Integer.parseInt(inputTimes);

        for (Car car : scoreBoard) {
            car.printcar();
        }
    }

    public ArrayList<Car> initScoreBoard(String[] names) {
        ArrayList<Car> board = new ArrayList<>();
        for (String name : names) {
            //exceptCarNameValidate(carName);
            board.add(new Car(name, 0));
        }
        return board;
    }

}
