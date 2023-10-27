package racingcar.view.output;

public class ConsoleOutputView implements OutputView {

    @Override
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void askPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printGameEnd() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
