package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarGroupDto;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_RESULT_FORMAT = "{0} : {1}";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : {0}";
    private static final String NAME_SEPARATOR = ", ";
    private static final String NEW_LINE = "\n";
    private static final String CAR_POSITION_SYMBOL = "-";

    public static void printRaceResultHeaderMessage() {
        System.out.println(NEW_LINE + RACE_RESULT_MESSAGE);
    }

    public static void printCarRaceResults(CarGroupDto carGroupDto) {
        carGroupDto.getCars().stream()
                .forEach(carDto -> System.out.println(formatCarDtoResult(carDto)));
        System.out.print(NEW_LINE);
    }

    public static void printWinnerNames(List<String> names) {
        System.out.println(MessageFormat.format(WINNER_MESSAGE_FORMAT, joinNamesToString(names)));
    }

    private static String formatCarDtoResult(CarDto carDto) {
        return MessageFormat.format(CAR_RESULT_FORMAT, carDto.getName(), generateCarPositionString(carDto.getPosition()));
    }

    private static String generateCarPositionString(Integer integer) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, integer)
                .forEach(i -> stringBuilder.append(CAR_POSITION_SYMBOL));
        return stringBuilder.toString();
    }

    private static String joinNamesToString(List<String> names) {
        return names.stream()
                .collect(Collectors.joining(NAME_SEPARATOR));
    }
}
