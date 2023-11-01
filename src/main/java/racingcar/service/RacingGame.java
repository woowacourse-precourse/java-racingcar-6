package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.input.count.CountReader;
import racingcar.input.name.NameReader;
import racingcar.output.DriverProgress;
import racingcar.output.ServicePrinter;
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

        int[] countsByName = DriverProgress.race(names, count);

        int maxCount = Arrays.stream(countsByName).max().orElse(0);

        List<String> winners = WinnerSelector.getWinners(maxCount, names, countsByName);

        servicePrinter.printWinnerMessage(winners);
    }
}
