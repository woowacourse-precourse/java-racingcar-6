package racingcar.view;

public class View {

    private final Input input;

    public View() {
        input = new ConsoleInput();

    }

    public String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input.readLine();
    }

    public String requestNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return input.readLine();
    }

    public void showResult(String winners) {
        System.out.print("최종 우승자 : " + winners);

    }
}
