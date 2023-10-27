package racingcar.domain;

import java.util.List;

public class GameResultGenerator {

    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public static GameResult generateResult(Cars cars) {
        List<Car> winnerCars = cars.getWinnerCars();
        String winnerNames = getWinnerNames(winnerCars);
        return new GameResult(FINAL_WINNER_MESSAGE + winnerNames);
    }

    private static String getWinnerNames(List<Car> winnerCars) {
        StringBuilder sb = new StringBuilder();
        winnerCars.forEach(car -> sb.append(car.getName() + ", "));

        int len = sb.length();
        sb.delete(len - 2, len);
        return sb.toString();
    }
}
