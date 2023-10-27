package racingcar.domain;

public class ConsoleOutput implements Output {
    @Override
    public void printCarNamesInputRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printMoveCountInputRequest() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
