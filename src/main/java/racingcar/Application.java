package racingcar;

import racingcar.controller.Controller;
import racingcar.view.View;

public class Application {

    private final View view;
    private final Controller controller;

    public Application() {
        this.view = new View();
        this.controller = new Controller();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        String clientMessage = view.requestCarNames();
        controller.registerCars(clientMessage);
        clientMessage = view.requestNumberOfAttempts();
        controller.playRace(clientMessage);
        String winners = controller.getResult();
        view.showResult(winners);
    }
}
