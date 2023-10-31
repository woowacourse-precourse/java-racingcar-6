package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
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

    public String getRacingCount() {
        String racingCount = Console.readLine();

        Message.printAskCountMessage(racingCount);
        return racingCount;
    }
}
