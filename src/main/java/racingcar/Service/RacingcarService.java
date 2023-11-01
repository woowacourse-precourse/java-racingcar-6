package racingcar.Service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.GameStatus;
import racingcar.Util.MoveConditionUtil;

public class RacingcarService {
    private final GameStatus gameStatus = new GameStatus();
    private final MoveConditionUtil moveConditionUtil = new MoveConditionUtil();
    public void initailizeGame(List<Car> carList, int goalRound) {
        gameStatus.setCarList(carList);
        gameStatus.setGoalRound(goalRound);
    }

    public void updateCarStatus(Car car) {
        car.addMovedCount();
        car.updateMovedStatus();
    }

    public String move(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for(Car car : carList) {
            if(moveConditionUtil.checkMoveCondition()) {
                updateCarStatus(car);
            }
            gameStatus.setMaxCount(car.getMovedCount());

            sb.append(car.getCarName()).append(" : ").append(car.getMovedStatus()).append("\n");
        }

        return sb.toString();
    }

    public String getRoundResult() {
        List<Car> carList = gameStatus.getCarList();
        int goalRound = gameStatus.getGoalRound();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < goalRound; i++) {
            sb.append(move(carList)).append("\n");
        }

        return sb.toString();
    }

    public String getGameResult() {
        List<Car> carList = gameStatus.getCarList();
        List<String> resultList = new ArrayList<>();

        for(Car car : carList) {
            if(gameStatus.getMaxCount() == car.getMovedCount()) {
                resultList.add(car.getCarName());
            }
        }

        return String.join(", ", resultList);
    }

}
