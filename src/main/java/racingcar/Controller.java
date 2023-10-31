package racingcar;
import racingcar.Service;

public class Controller {
    Service service = new Service();

    public void run() {
        userInput();

    }

    public void userInput() {
        service.userInput();
    }

}

