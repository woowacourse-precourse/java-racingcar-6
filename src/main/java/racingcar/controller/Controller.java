package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.repository.CarRepository;
import racingcar.repository.RaceRepository;
import racingcar.service.RaceService;
import racingcar.util.Parsing;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final Validation validation = new Validation();
    private final RaceService raceService = new RaceService();
    private final OutputView outputView = new OutputView();

    public void run() {
        //자동차 이름
        InputView.requestInputMessage();

        String carNameInput = Console.readLine();
        
        validation.checkCarNamesInput(carNameInput);

        String[] carName = carNameInput.split(",");
        int[] carPresentPoint = new int[carName.length];

        //시도 횟수
        InputView.requestTrialMessage();

        String trialInput = Console.readLine();

        validation.checkTrialInput(trialInput);

        int count = Integer.parseInt(trialInput);

        OutputView.responseExecution();
        raceService.resultOfExecution(count, carPresentPoint, carName);

        outputView.responseWinner(raceService.getWinner(carName, carPresentPoint));

    }

}
