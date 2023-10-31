package racingcar.domain.messenger;

import racingcar.dto.CarNamesDto;
import racingcar.dto.CarsInformationDto;

import static racingcar.domain.messenger.MessengerConstants.*;

public class Messenger {

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
