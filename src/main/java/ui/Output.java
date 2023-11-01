package ui;

import domain.Car;
import domain.RaceResult;
import domain.RaceStatus;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Output {
    private static final String CAR_NAMES_INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_NUMBER_INPUT_REQUEST_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String MOVE_RESULT_NOTICE_MESSAGE = "실행 결과";
    private static final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";
    public static final String NULL_EXCEPTION_MESSAGE = "입력이 NULL이 될 수 없습니다.";
    public static final String ATTEMPT_NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";
    public static final String VALID_ATTEMPT_NUMBER_EXCEPTION_MESSAGE = "0보다 큰 숫자를 입력해주세요.";
    public static final String CAR_NAME_FORMAT_EXCEPTION_MESSAGE = "자동차 이름은 공백을 제외한 숫자와 영문자만 가능합니다.";
    public static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "자동차 이름의 길이는 5글자까지만 가능합니다.";
    public static final String CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE = "중복된 자동차 이름이 존재합니다.";
    public static final String VALID_POSITION_EXCEPTION_MESSAGE = "자동차의 위치가 유효하지 않습니다.";

    public static void printRequestCarNamesInput() {
        System.out.println(CAR_NAMES_INPUT_REQUEST_MESSAGE);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printRequestAttemptNumberInput() {
        System.out.println(ATTEMPT_NUMBER_INPUT_REQUEST_MESSAGE);
    }

    public static void printRacingStatus(RaceStatus raceStatus) {
        StringBuilder sb = new StringBuilder();
        raceStatus.getCurrentStatus().forEach(car -> {
            sb.append(car.getName())
                    .append(" : ")
                    .append(Stream.generate(() -> "-")
                            .limit(car.getPosition())
                            .collect(Collectors.joining()))
                    .append("\n");
        });
        System.out.println(sb.toString());
    }

    public static void printRaceResult(RaceResult raceResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(MOVE_RESULT_NOTICE_MESSAGE).append('\n');

        raceResult.getRaceResult().forEach(raceStatus -> {
                    printCurrentStatus(raceStatus, sb);
                }
        );
        System.out.println(sb.toString());
    }

    public static void printCurrentStatus(RaceStatus raceStatus, StringBuilder sb) {
        raceStatus.getCurrentStatus().forEach(car -> {
            sb.append(car.getName())
                    .append(" : ")
                    .append(Stream.generate(() -> "-")
                            .limit(car.getPosition())
                            .collect(Collectors.joining()))
                    .append("\n");
        });
        sb.append("\n");
    }

    public static void printRaceWinner(RaceResult raceResult) {
        String winners = raceResult.getWinner()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners + WINNER_RESULT_MESSAGE);
    }
}
