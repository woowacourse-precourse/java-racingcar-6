package racingcar.view;

import java.util.List;
리import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.CarsDto;
import racingcar.util.Constants;
import racingcar.util.StringUtils;

public class OutputView {

    private boolean isFirstTime = true;

    public void printMoveResult(final CarsDto carsDto) {
        printGameResultMessageForFirstTime();

        for (CarDto carDto : carsDto.cars()) {
            String dashes = StringUtils.repeatDash(carDto.position());
            System.out.printf("%s : %s\n", carDto.carName(), dashes);
        }
        System.out.println();
    }

    private void printGameResultMessageForFirstTime() {
        if (!isFirstTime) {
            return;
        }

        System.out.println("\n" + Constants.GAME_RESULT_MESSAGE);
        this.isFirstTime = false;
    }

    public void printWinner(List<String> winnerList) {
        if (winnerList.size() > 1) {
            String winners = winnerList.stream().collect(Collectors.joining(", "));
            System.out.println(Constants.GAME_WINNER_MESSAGE + winners);
            return;
        }

        String winner = winnerList.get(0);
        System.out.println(Constants.GAME_WINNER_MESSAGE + winner);
    }

    private String converterPosition(final int position) {
        return "-".repeat(position);
    }
}
