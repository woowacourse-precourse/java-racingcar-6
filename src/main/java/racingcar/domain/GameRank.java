package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *   게임 결과와 우승자의 정보를 담당
 * */
public class GameRank {
    private static final int ONE_WINNER = 1;
    private static final int ONE_WINNER_INDEX = 0;
    private static final int STRING_BEGIN_INDEX = 0;
    private static final int NOT_USED_LENGTH = 2;
    private List<Car> gameResult;
    private List<Car> gameWinners = new ArrayList<>();

    public GameRank(List<Car> gameResult) {
        Collections.sort(gameResult);
        this.gameResult = gameResult;
        System.out.println(this.gameResult);
    }

    public void createGameWinners(int record) {
        for (Car car : gameResult) {
            addGameWinners(car, record);
        }
    }

    private void addGameWinners(Car car, int bestRecord) {
        if (car.isEqualRecord(bestRecord)) {
            gameWinners.add(car);
        }
    }

    public String winnersNameToString() {
        String winnersName = new String("");
        if (gameWinners.size() == ONE_WINNER) {
            return makeNameString(winnersName);
        }
        return makeNamesString(winnersName);
    }

    private String makeNameString(String winnersName) {
        Car car = gameWinners.get(ONE_WINNER_INDEX);
        return car.intoWinnersName(winnersName);
    }

    private String makeNamesString(String winnersName) {
        for (Car gameWinner : gameWinners) {
            winnersName = gameWinner.intoWinnersName(winnersName);
            winnersName += ", ";
        }
        return winnersName.substring(STRING_BEGIN_INDEX, winnersName.length() - NOT_USED_LENGTH);
    }
    //commit하면서 문맥상 이상, 변수명 이상, 흐름 이상 확인해서 리팩토링 후에 테스트
}
