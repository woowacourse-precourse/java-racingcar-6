package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InOutputView view = new InOutputView();
        RaceController controller = new RaceController(view);
        controller.start();
    }
}
