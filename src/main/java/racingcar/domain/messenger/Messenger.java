package racingcar.domain.messenger;

import racingcar.dto.CarNamesDto;
import racingcar.dto.CarsInformationDto;

public class Messenger {

    private static final String REQUEST_CAR_NAMES_FORMAT = "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)\n";
    private static final String CAR_NAMES_DELIMITER_DESCRIPTION = "쉼표";
    public static final String CAR_NAMES_DELIMITER = ",";

    private static final String REQUEST_ROUND_COUNT = "시도할 회수는 몇회인가요?\n";

    private static final String PLAY_RESULT_MESSAGE = "\n실행결과\n";

    private static final String CAR_INFORMATION_FORMAT = "%s : %s\n";
    private static final String CAR_POSITION_PRESENTER = "-";
    private static final String NEXT_LINE = "\n";

    private static final String WINNER_FORMAT = "최종 우승자 : %s\n";
    private static final String WINNERS_DELIMITER = ", ";

    public String getRequestCarNames() {
        return String.format(REQUEST_CAR_NAMES_FORMAT, CAR_NAMES_DELIMITER_DESCRIPTION, CAR_NAMES_DELIMITER);
    }

    public String getRequestRoundCount() {
        return REQUEST_ROUND_COUNT;
    }

    public String getPlayResultMessage() {
        return PLAY_RESULT_MESSAGE;
    }

    public String getRoundResult(CarsInformationDto carsInformationDto) {
        StringBuilder stringBuilder = new StringBuilder();
        carsInformationDto.carInformationDtoList()
                .forEach(carInformationDto -> {
                    String name = carInformationDto.name();
                    int position = carInformationDto.position();
                    String carPositionString = CAR_POSITION_PRESENTER.repeat(position);
                    String carInformationString = String.format(CAR_INFORMATION_FORMAT, name, carPositionString);
                    stringBuilder.append(carInformationString);
                });
        stringBuilder.append(NEXT_LINE);
        return stringBuilder.toString();
    }

    public String getWinners(CarNamesDto carNamesDto) {
        String winners = String.join(WINNERS_DELIMITER, carNamesDto.names());
        return String.format(WINNER_FORMAT, winners);
    }

}
