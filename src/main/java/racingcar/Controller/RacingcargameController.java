package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Game;
import racingcar.Exception.CarNameException;
import racingcar.Exception.TryCountNumberException;
import racingcar.Repository.CarRepository;
import racingcar.Service.GameFlowManagementService;
import racingcar.Util.StringToList;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingcargameController {
    private final GameFlowManagementService gameFlowManagementService;
    private final StringToList stringToList;
    private final CarNameException carNameException;
    private final TryCountNumberException tryCountNumberException;
    private final CarRepository carRepository;

    public RacingcargameController() {
        this.gameFlowManagementService = new GameFlowManagementService();
        this.stringToList = new StringToList();
        this.carNameException = new CarNameException();
        this.tryCountNumberException = new TryCountNumberException();
        this.carRepository = new CarRepository();
    }

    public void startRacingCarGame() {
        while (true) {
            if (playRacingCarGame()) {
                break;
            }
        }
    }

    public boolean playRacingCarGame() {
        String playerCarNames = getPlayerCarNames();
        String tryCountNumber = getTryCountNumber();

        try {
            List<String> carNames = stringToList.analysisCarNames(playerCarNames);
            int tryCount = stringToList.analysisTryCountNumber(tryCountNumber);

            saveCarNamesToRepo(carNames);
            manageRacingCarGame(tryCount);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.showCarNameAndTryCountException(e.getMessage());
            return false;
        }
    }

    private void manageRacingCarGame(int tryCount) {
    }
    //입력받을 자동차 이름과 시도 횟수에 대한 메서드
    private void saveCarNamesToRepo(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.saveCarName(new Car(carName));
        }
    }

    private String getPlayerCarNames() {
        InputView.showCarNameInputPrompt();
        String playerCarNames = Console.readLine();
        carNameException.validateCarNameInput(playerCarNames); // 입력 유효성 검사
        return playerCarNames;
    }

    private String getTryCountNumber() {
        InputView.showTryCountNumPrompt();
        String tryCountNumber = Console.readLine();
        tryCountNumberException.validateTryCountInput(tryCountNumber); // 입력 유효성 검사
        return tryCountNumber;
    }
}
