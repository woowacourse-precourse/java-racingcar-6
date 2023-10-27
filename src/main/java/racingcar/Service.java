package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Service {
    private final ProgressBoard progressBoard;
    private final InputView inputView ;
    private final OutputView outputView;
    private final int GO_NUMBER = 4;

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

    public boolean canMoveForward() {
        return numberGenerator.getRandomNumber() >= GO_NUMBER;
    }

    public void showProgressOf(List<String> participants) {
        outputView.printProgressMessage(participants, progressBoard);
    }
    public void printResultMessage() {
        outputView.printResultMessage();
    }
}
