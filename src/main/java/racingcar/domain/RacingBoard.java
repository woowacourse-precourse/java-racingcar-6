package racingcar.domain;

import java.util.ArrayList;

public class RacingBoard {
    private ArrayList<Car> board = new ArrayList<>();
    private ArrayList<String> winnerBoard = new ArrayList<>();

    public void join(Car car) {
        board.add(board.size(), car);
    }

    public void joinManyCars(ArrayList<String> carsName) {
        for (String carName : carsName) {
            Car car;
            join(car = new Car(carName));
        }
    }

    public ArrayList<Car> view() {
        return board;
    }

    public void recordWinner(ArrayList<String> winnerBoard) {
        this.winnerBoard = winnerBoard;
    }

    public String viewWinner() {
        StringBuilder winnerStr = new StringBuilder();
        for (int i = 0; i < winnerBoard.size(); i++) {
            winnerStr.append(winnerBoard.get(i));
            if (i < (winnerBoard.size() - 1)) {
                winnerStr.append(", ");
            }
        }
        return winnerStr.toString();
    }

    public String viewExecution() {
        StringBuilder executionStr = new StringBuilder();
        for (Car car : board) {
            executionStr.append(car.getName());
            executionStr.append(" : ");
            executionStr.append("-".repeat(car.getLocation()));
            executionStr.append("\n");
        }
        return executionStr.toString();
    }
}
