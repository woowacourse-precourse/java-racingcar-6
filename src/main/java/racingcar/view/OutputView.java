package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.CarsDto;
import racingcar.domain.WinnerDto;
import racingcar.util.StringUtils;

public class OutputView {

    public static final String GAME_RESULT_MESSAGE = "실행 결과";
    public static final String GAME_WINNER_MESSAGE = "최종 우승자 : ";

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

        System.out.println("\n" + GAME_RESULT_MESSAGE);
        this.isFirstTime = false;
    }

    public void printWinner(final WinnerDto winnerDto) {
        printMultipleWinners(winnerDto);

        String winner = winnerDto.winners().get(0).getName();
        System.out.println(GAME_WINNER_MESSAGE + winner);
    }

    private void printMultipleWinners(final WinnerDto winnerDto) {
        if (winnerDto.winners().size() > 1) {
            return;
        }

        String winners = winnerDto.winners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(GAME_WINNER_MESSAGE + winners);
    }
}
