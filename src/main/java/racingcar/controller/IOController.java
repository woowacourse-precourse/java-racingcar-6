package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.IOView;

public class IOController {
    private final IOView ioView;

    public IOController() {
        this.ioView = new IOView();
    }

    public void showIntroMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRequestRoundNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public String getUserInput() {
        return Console.readLine();
    }

    public Integer getRoundNumber() {
        String userInput = getUserInput();
        // validate
        //1. is numver
        //2. is number given singe ?

        return Integer.parseInt(userInput);
    }

    public List<String> getCarNames() {
        String userInput = getUserInput();
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
        System.out.print("최종 우승자 : ");
        String winnerNames = message.toString().replace("[", "").replace("]", "");
        ioView.showSingleMessage(winnerNames);
    }
}
