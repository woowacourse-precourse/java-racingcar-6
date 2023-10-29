package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarGroupDto;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_RACE_RESULT = "{0} : {1}";
    private static final String WIN_CARS_MESSAGE = "최종 우승자 : {0}";
    private static final String SPLIT_NAME_COMMA = ", ";
    private static final String GAP = "\n";
    private static final String CAR_POSITION = "-";

    public static void printRaceResult() {
        System.out.println(GAP + RACE_RESULT_MESSAGE);
    }

    public static void printRacingResult(CarGroupDto carGroupDto) {
        carGroupDto.getCars().stream()
                .forEach(carDto -> System.out.println(toStringCarDto(carDto)));
        System.out.print(GAP);
    }

    public static void printWinCars(List<String> names) {
        System.out.println(MessageFormat.format(WIN_CARS_MESSAGE, toStringCarNames(names)));
    }

    private static String toStringCarDto(CarDto carDto) {
        return MessageFormat.format(CAR_RACE_RESULT, carDto.getName(), toStringCarPosition(carDto.getPosition()));
    }

    private static String toStringCarPosition(Integer integer) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, integer)
                .forEach(i -> stringBuilder.append(CAR_POSITION));
        return stringBuilder.toString();
    }

    private static String toStringCarNames(List<String> names) {
        return names.stream()
                .collect(Collectors.joining(SPLIT_NAME_COMMA));
    }
}
