package racingcar.view;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.util.GameResult;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private final static String FINAL_WINNER = "최종 우승자 : ";

    public void printGameResult(List<Car> list, Referee referee) {

        StringBuilder sb = new StringBuilder();

        sb.append(GAME_RESULT).append('\n');
        GameResult instance = GameResult.getInstance();
        StringBuilder gameResult = instance.getGameResult();
        sb.append(gameResult);

        sb.append(winnerName(referee.selectWinnerList(list))).append('\n');

        System.out.println(sb);
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

