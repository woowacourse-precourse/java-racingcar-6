package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class ConsoleInputView implements InputView {
    @Override
    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    @Override
    public String askRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return readLine();
    }
}
