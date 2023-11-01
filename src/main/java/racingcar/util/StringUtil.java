package racingcar.util;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;

public class StringUtil {
    public String makeResultMessage(RacingGame game) {
        StringBuilder sb = new StringBuilder();
        List<Car> cars = game.getCars();
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ");
            for (long i = 0; i < car.getDistance(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String makeFinalResult(RacingGameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        List<String> winners = gameResult.getWinners();
        sb.append("최종 우승자 : ").append(winners.get(0));
        for(int i = 1; i < winners.size(); i++) {
            sb.append(", ").append(winners.get(i));
        }
        return sb.toString();
    }
}
