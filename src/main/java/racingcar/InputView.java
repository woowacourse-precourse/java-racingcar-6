package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    Player player = new Player();
    GameException gameException = new GameException();

    public void inputPlayerCarName() {
        String carName = Console.readLine();
        String[] carNames = carName.split(",");
        checkCarNamesLoop(carNames);
        player.settingPlayerCarNameStore(carNames);
    }

    private void checkCarNamesLoop(String[] carNames) {
        for (String carName : carNames) {
            checkCarNameException(carName);
        }
    }

    private void checkCarNameException(String carName) {
        gameException.validatePlayerCarNameLengthRange(carName);
        gameException.validatePlayerCarNameBlank(carName);
        gameException.validatePlayerCarNameType(carName);
        gameException.validatePlayerCarNameOnlyLowerCase(carName);
    }
}
