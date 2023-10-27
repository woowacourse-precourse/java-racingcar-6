package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view=new View();
        RacingGame racingGame=new RacingGame();
        Controller controller=new Controller(view,racingGame);

        controller.start();
    }
}
