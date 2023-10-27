package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Service {
    private final ProgressBoard progressBoard;
    private final InputView inputView ;
    private final OutputView outputView;

    public Service() {
        this.progressBoard = ProgressBoard.getInstance();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public String receiveParticipants() {
        inputView.printCarNameMessage();
        String input = Console.readLine();
        return input;
    }
    public String receiveTrialCount() {
        inputView.printTryCountMessage();
        String input = Console.readLine();
        return input;
    }
    public void registerParticipants(List<String> participants) {
        progressBoard.registerCars(participants);
    }
    public void moveForward(String carName) {
        progressBoard.moveForward(carName);
    }

}
