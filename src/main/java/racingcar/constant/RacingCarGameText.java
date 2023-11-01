package racingcar.constant;

public interface RacingCarGameText {
    String RACINGCAR_REQUEST_MULTIPLE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    String RACINGCAR_REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";
    String RACINGCAR_EXECUTE_RESULT = "실행 결과";
    String RACINGCAR_FORMAT_STATUS = "%s : %s";
    String RACINGCAR_FORMAT_FINAL_WINNER = "최종 우승자 : %s";
    String RACINGCAR_DOES_NOT_MOVE = "\u200B"; // zero-width-space trim()에 지워지지 않는 값.
    String RACINGCAR_LOCATION_SYMBOL = "-";
    String RACINGCAR_WINNERS_DELIMITER = ", ";
    String RACINGCAR_SPLIT_DELIMITER = ",";
}
