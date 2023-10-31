package racingcar.view;

import static racingcar.domain.enums.Constants.MIN_RACING_COUNT;
import static racingcar.domain.enums.Error.INVALID_MIN_RACE_COUNT;
import static racingcar.domain.enums.Error.INVALID_NUMBER_FOMMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.ErrorException;
import racingcar.util.Message;

public class InputView {
    public InputView() {
    }

    public List<Car> createRacingCar() {
        Message.printStartMessage();
        String carNames = Console.readLine();

        Message.printCreateCarListMessage(carNames);

        return Arrays.stream(carNames.split(","))
                .map(x -> new Car(x))
                .collect(Collectors.toList());
    }

    public int getRacingCount() {
        int racingCount = validateNumber(Console.readLine());
        validateMinRacingCount(racingCount);

        Message.printAskCountMessage(racingCount);
        return racingCount;
    }

    private void validateMinRacingCount(int racingCount) {
        if (racingCount < MIN_RACING_COUNT) {
            throw new ErrorException(INVALID_MIN_RACE_COUNT);
        }
    }

    private int validateNumber(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new ErrorException(INVALID_NUMBER_FOMMAT);
        }
    }
}
