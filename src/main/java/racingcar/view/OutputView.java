package racingcar.view;

import static racingcar.controller.RaceController.gameResult;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private final static String FINAL_WINNER = "최종 우승자 : ";

    public void printGameResult(List<Car> list, Referee referee) {
        gameResult.append(GAME_RESULT).append('\n');
        gameResult.append(winnerName(referee.selectWinnerList(list))).append('\n');
        System.out.println(gameResult);
    }

    // 우승자 이름을 반환한다.
    public String winnerName(List<Car> sortedCarList) {
        String baseName = sortedCarList.get(0).getName();
        Integer baseScore = sortedCarList.get(0).getDistance();

        for (int i = 1; i < sortedCarList.size(); i++) {
            if (baseScore.equals(sortedCarList.get(i).getDistance())) {
                baseName += ", " + sortedCarList.get(i).getName();
            }
        }
        return FINAL_WINNER + baseName;
    }
}

