package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.config.GameMessage;
import racingcar.dto.CarRegistrationDTO;
import racingcar.util.converter.CarRegistrationConverter;
import racingcar.util.validator.CarNamesValidator;
import racingcar.util.validator.RoundCountValidator;

public class InputHandlerImpl implements InputHandler {

    @Override
    public List<CarRegistrationDTO> getCarRegistrations() {
        printRequest(GameMessage.REQUEST_CAR_NAMES);
        String carNames = readLine();
        CarNamesValidator.validate(carNames);

        return CarRegistrationConverter.convertToDTOs(carNames);
    }

    @Override
    public int getRaceRoundCount() {
        printRequest(GameMessage.REQUEST_ROUND_COUNT);
        String roundCount = readLine();
        RoundCountValidator.validate(roundCount);

        return Integer.parseInt(roundCount);
    }

    private String readLine() {
        return Console.readLine();
    }

    private void printRequest(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }
}
