package racingcar.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력 하세요.(이름은 쉼표(,) 기준 으로 구분)";

    public String readRaceCarNames() {
        System.out.println(ENTER_CAR_NAME);
        return readLine();
    }

    protected String readLine(){
        return Console.readLine();
    }
}
