package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final ProgressBoard progressBoard;
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private final int GO_NUMBER = 4;
    private List<String> participants;

    public Service() {
        this.progressBoard = ProgressBoard.getInstance();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = new NumberGenerator();
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
        this.participants = participants;
        progressBoard.registerCars(participants);
    }

    public void moveForward(String carName) {
        progressBoard.moveForward(carName);
    }

    public boolean canMoveForward() {
        return numberGenerator.getRandomNumber() >= GO_NUMBER;
    }

    public void showProgressOf() {
        outputView.printProgressMessage(participants, progressBoard);
    }

    public void printResultMessage() {
        outputView.printResultMessage();
    }

    public void showFinalWinner() {
        List<String> winners = getWinners();
        outputView.printFinalWinner(winners);
    }

    private List<String> getWinners() {
        int maxMove = getMaxMove();
        List<String> winners = new ArrayList<>();
        for (String participant : participants) {
            if (progressBoard.progressOf(participant).length() == maxMove) {
                winners.add(participant);
            }
        }
        return winners;
    }

    private int getMaxMove() {
        int result = 0;
        for (String key : progressBoard.getParticipants()) {
            result = Math.max(result, progressBoard.progressOf(key).length());
        }
        return result;
    }
}
