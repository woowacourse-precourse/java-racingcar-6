package racingcar.view;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.dto.GameResultDto;

public class OutputView {

    private final MessageResolver messageResolver = new MessageResolver();

    public void showRoundResult(List<Car> cars) {
        System.out.println(messageResolver.resolveRoundResultMessage(cars));
    }

    public void showGameResult(GameResultDto gameResult) {
        System.out.println(messageResolver.resolveWinnerMessage(gameResult));
    }


}
