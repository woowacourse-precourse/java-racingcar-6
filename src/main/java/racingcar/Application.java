package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.CarList;
import racingcar.repository.SaveCarList;
import racingcar.repository.UpdateProgress;
import racingcar.service.*;
import racingcar.view.PrintAll;

public class Application {
    private CarList carList = new CarList();
    private InputCarName inputCarName;
    private InputTryNumber inputTryNumber;
    private GetRandomNumber getRandomNumber;
    private PrintAll printAll;
    private UpdateProgress updateProgress;
    private Winner winner;
    private SaveCarList saveCarList;
    private ParsingCarName parsingCarName;

    public Application() {
        this.inputTryNumber=new InputTryNumber();
        this.printAll=new PrintAll();
        this.getRandomNumber=new GetRandomNumber();
        this.updateProgress = new UpdateProgress();
        this.winner = new Winner();
        this.saveCarList = new SaveCarList(carList);



    }

    public void run() {
        // TODO: 프로그램 구현
        Controller controller = new Controller(inputCarName, inputTryNumber, getRandomNumber, printAll, updateProgress, winner, parsingCarName, saveCarList,carList);
        controller.start();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
