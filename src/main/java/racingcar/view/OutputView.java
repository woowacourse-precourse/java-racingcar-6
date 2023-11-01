package racingcar.view;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.util.GameResult;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private final static String FINAL_WINNER = "최종 우승자";
    private final static String DELIMITER = " : ";
    private final static String CAR_POSITION = "-";
    private final static String WINNERS_DELIMITER = ", ";
    private final static String RED_LIGHT = "빨간 불 입니다!! [이동하는 차량이 없습니다.] ";

    public void printGameResult(List<Car> list, Referee referee) {

        StringBuilder sb = new StringBuilder();

        sb.append(GAME_RESULT).append('\n');
        GameResult instance = GameResult.getInstance();
        StringBuilder gameResult = instance.getGameResult();
        sb.append(gameResult);

        sb.append(getWinnerNames(referee.selectWinnerList(list))).append('\n');

        System.out.println(sb);
    }

    public String getWinnerNames(List<Car> sortedCarList) {
        String baseName = sortedCarList.get(0).getName();
        Integer baseScore = sortedCarList.get(0).getDistance();

        for (int i = 1; i < sortedCarList.size(); i++) {

            if (baseScore.equals(sortedCarList.get(i).getDistance())) {
                baseName += WINNERS_DELIMITER + sortedCarList.get(i).getName();
            }
        }
        return FINAL_WINNER + DELIMITER + baseName;
    }

    public static String distanceToPosition(Car car) {
        int distance = car.getDistance();

        if (distance <= 0) {
            return "";
        }

        String position = CAR_POSITION.repeat(distance);

        return position;
    }

    public static String nameConcatDelim(Car car) {
        String name = car.getName();
        return name + DELIMITER;
    }

    public static String redLight() {
        return RED_LIGHT;
    }
}

