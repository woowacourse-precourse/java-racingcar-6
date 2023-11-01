package racingcar;
import racingcar.Service;

public class Controller {
    Service service = new Service();

    public void play() {
        userInput();

    }

    public void userInput() {
        service.userInput();
    }

}

