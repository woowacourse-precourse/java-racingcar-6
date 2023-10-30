package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.IntStream;
import racingcar.domain.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final CarList carList = new CarList();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void gameStart() {
        inputView.printCarNameInputMessage();
        String carNames = Console.readLine();
        carList.splitCarNames(carNames);

        inputView.printAttemptNumberInputMessage();
        int attempt = Integer.parseInt(Console.readLine());

        IntStream.range(0, attempt)
                .forEach(i -> outputView.printResult(carList));

        outputView.printWinners(carList.getWinners());
    }
}