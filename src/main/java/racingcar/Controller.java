package racingcar;
import racingcar.Service;

public class Controller {
    Service service = new Service();

    public void play() {
        userInput();
        gamePlay();

    }

    public void userInput() {
        service.userInput();
    }

    public void gamePlay() {
        service.gamePlay();
    }

}

