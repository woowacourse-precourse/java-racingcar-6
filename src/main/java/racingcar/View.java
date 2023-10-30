package racingcar;

public class View {

    private final String COLON = " : ";

    public void printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCount() {
        System.out.println("시도할 횟수는 몇 번인가요?");
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void printResult() {
        System.out.println("실행결과");
    }

    public void printCarName(String carName) {
        System.out.print(carName + COLON);
    }

    public void printForward(String forward) {
        System.out.println(forward);
    }

    public void printBlank() {
        System.out.println();
    }
}
