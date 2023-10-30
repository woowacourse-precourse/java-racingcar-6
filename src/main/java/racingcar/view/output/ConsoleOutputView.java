package racingcar.view.output;

public class ConsoleOutputView implements Outputview {

    @Override
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void askPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printEachCarStatus() {

    }

    @Override
    public void printWinners() {
        System.out.println("최종 우승자 : ");
    }
}
