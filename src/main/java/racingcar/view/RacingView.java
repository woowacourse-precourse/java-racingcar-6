package racingcar.view;

import static racingcar.constant.RacingMessage.getInputCarNameMessage;
import static racingcar.constant.RacingMessage.getInputTryCountMessage;
import static racingcar.constant.RacingMessage.getTryResultMessage;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.response.WinnerNames;

public class RacingView {

    private final InputMapper inputMapper;
    private final OutputMaker outputMaker;

    public RacingView(InputMapper inputMapper, OutputMaker outputMaker) {
        this.inputMapper = inputMapper;
        this.outputMaker = outputMaker;
    }

    public CarNames inputCarNames() {
        write(getInputCarNameMessage());
        return inputMapper.toCarNames(getInput());
    }

    public TryCount inputTryCount() {
        write(getInputTryCountMessage());
        return inputMapper.toTryCount(getInput());
    }

    public void startPrintTryResult() {
        write(getTryResultMessage());
    }

    public void showRacingStatus(RacingStatus racingStatus) {
        write(outputMaker.makeRacingStatusOutput(racingStatus));
    }

    public void showRacingWinner(WinnerNames winnerNames) {
        write(outputMaker.makeRacingWinnerOutput(winnerNames));
    }

    private void write(String message) {
        System.out.println(message);
    }

    private String getInput() {
        return Console.readLine();
    }
}
