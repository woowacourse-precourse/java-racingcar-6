package racingcar.view;

import static racingcar.util.GameConstants.CAR_NAME_DELIMITER;
import static racingcar.util.GameConstants.CAR_NAME_DELIMITER_KOR;

public class OutputViewImpl implements OutputView{
    @Override
    public void displayCarNameInputNotice() {
        String output = "경주할 자동차 이름을 입력하세요.(이름은 " + CAR_NAME_DELIMITER_KOR + "(" + CAR_NAME_DELIMITER + ") 기준으로 구분)";
        System.out.println(output);
    }

    @Override
    public void displayMoveCountInputNotice() {
        String output = "시도할 횟수는 몇회인가요?";
        System.out.println(output);
    }

    @Override
    public void displayRaceStatus() {

    }

    @Override
    public void displayWinners() {

    }
}
