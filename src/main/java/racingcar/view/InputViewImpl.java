package racingcar.view;

import static racingcar.util.GameConstants.CAR_NAME_DELIMITER;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView{
    @Override
    public String[] getCarNamesFromUsers() {
        return Console.readLine().split(CAR_NAME_DELIMITER, -1);
    }

    @Override
    public String getMoveCountFromUsers() {
        return Console.readLine();
    }
}
