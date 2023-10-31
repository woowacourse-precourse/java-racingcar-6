package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        start();
    }

    static void start() {

        RacingView racingView = new RacingView();

        racingView.inputCarNames();
        racingView.inputPlayCount();

        racingView.printPlayResult();
    }
}
