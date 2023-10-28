package racingcar.view;

import java.util.List;
import racingcar.config.GameConfig;
import racingcar.domain.RoundResult;
import racingcar.domain.RoundResult.CarDto;

public class OutputView {

    private static final String RESULT_PREFIX = "\n실행 결과\n";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    public static void printGameResult(List<RoundResult> results) {
        StringBuilder stringBuilder = new StringBuilder();

        results.forEach(result -> {
            stringBuilder
                    .append(formatRoundResult(result))
                    .append(System.lineSeparator());
        });

        System.out.print(RESULT_PREFIX + stringBuilder);
    }

    private static String formatRoundResult(RoundResult result) {
        StringBuilder stringBuilder = new StringBuilder();

        result.carsDto().carDtos()
                .forEach(carDto -> {
                    stringBuilder
                            .append(formatCar(carDto))
                            .append(System.lineSeparator());
                });

        return stringBuilder.toString();
    }

    private static String formatCar(CarDto carDto) {
        return carDto.name()
                + " : "
                + GameConfig.POSITION_VIEW_EXPRESSION.repeat(carDto.position());
    }

    public static void printWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE_PREFIX
                + String.join(GameConfig.CAR_NAME_DELIMITER + " ", winners)
        );
    }
}
