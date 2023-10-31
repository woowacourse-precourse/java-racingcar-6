package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.IOView;

public final class IOController {
    private final IOView ioView;

    public IOController() {
        this.ioView = new IOView();
    }

    public void showIntroMessage() {
        String introMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        ioView.showSingleMessage(introMessage);
    }

    public void showRequestRoundNumberMessage() {
        String askRoundMessage = "시도할 회수는 몇회인가요?";
        ioView.showSingleMessage(askRoundMessage);
    }

    public String getUserRequest() {
        return ioView.getUserRequest();
    }

    public Integer getRoundNumber() {
        String userInput = getUserRequest();
        // validate
        //1. is numver
        //2. is number given singe ?
        return Integer.parseInt(userInput);
    }

    public List<String> getCarNames() {
        String userInput = getUserRequest();
        //validate
        //validate it contains with ,
        List<String> carNames = Arrays.asList(userInput.split(","));
        //check duplicate name
        //check is name is eng
        // check is namae is lang  5
        carNames.stream().map(name -> {
            Car.validateName(name);
            return name;
        }).toList();
        return carNames;
    }

    public void showRoundResult(List<String> message) {
        ioView.showMessages(message);
    }

    public void showWinner(List<String> message) {
        String winnerHeadMessage = "최종 우승자 : ";
        ioView.showHeadMessage(winnerHeadMessage);
        String winnerNames = message.toString().replace("[", "").replace("]", "");
        ioView.showSingleMessage(winnerNames);
    }
}
