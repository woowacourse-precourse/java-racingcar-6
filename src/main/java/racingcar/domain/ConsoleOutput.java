package racingcar.domain;

public class ConsoleOutput implements Output {
    private StringBuilder stringBuilder;

    public ConsoleOutput() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void printCarNamesInputRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printMoveCountInputRequest() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void addCarState(String name, int path) {
        stringBuilder.append(name + " : " + "-".repeat(path) + "\n");
    }

    @Override
    public void printCarsState() {
        System.out.println(stringBuilder);
        stringBuilder.setLength(0); //버퍼 비우기
    }

    @Override
    public void printResultStartedMessage() {
        System.out.println("\n실행 결과");
    }
}
