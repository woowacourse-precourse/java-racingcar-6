package racingcar.service.main;

import java.util.Arrays;
import java.util.List;
import racingcar.input.count.CountReader;
import racingcar.input.name.NameReader;
import racingcar.service.movement.MovementStatus;
import racingcar.output.ServicePrinter;
import racingcar.service.movement.MovementStatus.RandomMovementStrategy;
import racingcar.service.movement.RacingCarController.MovementStrategy;
import racingcar.service.winner.WinnerSelector;

public class RacingGame {
    public void startGame() {
        ServicePrinter servicePrinter = new ServicePrinter();
        // 이름 입력 문구 출력
        servicePrinter.printStartMessage();

        String[] names = NameReader.read();

        // 횟수 입력 문구 출력
        servicePrinter.printInputMessage();

        // 횟수 입력 받기
        int count = CountReader.read();

        servicePrinter.printOutputMessage();

        MovementStrategy randomMovementStrategy = new RandomMovementStrategy();
        MovementStatus movementStatus = new MovementStatus(randomMovementStrategy);

        int[] countsByName = movementStatus.race(names, count);

        if(count == 0) {
            ServicePrinter.printRaceStatus(names, countsByName);
        }

        int maxCount = Arrays.stream(countsByName).max().orElse(0);

        List<String> winners = WinnerSelector.getWinners(maxCount, names, countsByName);

        servicePrinter.printWinnerMessage(winners);
    }
}
