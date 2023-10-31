package racingcar;

/**
 * main
 */
public class Application {
    RacingController racingController = new RacingController();

    void boot() {
        racingController.launch();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.boot();
    }
}
