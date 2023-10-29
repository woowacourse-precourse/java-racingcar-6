package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
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

    public void printWinner(final List<Car> winnerList) {
        printMultipleWinners(winnerList);

        String winner = winnerList.get(0).getName();
        System.out.println(Constants.GAME_WINNER_MESSAGE + winner);
    }

    private void printMultipleWinners(final List<Car> winnerList) {
        if (winnerList.size() > 1) {
            return;
        }

        String winners = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(Constants.GAME_WINNER_MESSAGE + winners);
    }
}
