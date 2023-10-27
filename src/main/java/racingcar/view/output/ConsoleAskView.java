package racingcar.view.output;

public class ConsoleAskView implements AskView {

    @Override
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
