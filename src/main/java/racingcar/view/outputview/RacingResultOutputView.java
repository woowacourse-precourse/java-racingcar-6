package racingcar.view.outputview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.RacingCars;

public class RacingResultOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        RacingCars racingCars = (RacingCars) model.get("racingCars");
        showWinners(racingCars);
    }

    private void showWinners(RacingCars racingCars) {
        List<String> winnerNames = racingCars.findWinner()
                .stream()
                .map(winner -> winner.getCarName())
                .collect(Collectors.toList());

        String winnerNamesWithComma = String.join(", ", winnerNames);
        System.out.printf("%s : %s\n", "최종 우승자", winnerNamesWithComma);
    }
}
