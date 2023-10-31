package racingcar.controller;

import racingcar.domain.Car;
import racingcar.repository.SaveCarList;
import racingcar.service.*;
import racingcar.view.PrintAll;

import java.util.List;

public class Controller {
    private int tryNumber;
    private final InputCarName inputCarName = new InputCarName();
    private final ParsingCarName parsingCarName = new ParsingCarName();
    private final InputTryNumber inputTryNumber = new InputTryNumber();
    private final GetRandomNumber getRandomNumber = new GetRandomNumber();

    private final PrintAll printAll = new PrintAll();

    //게임 시작
    public void start() {
        run(inputCarName.getCarName(), inputTryNumber.getTryNumber());

        printAll.outputResultPrint();
    }
        SaveCarList saveCarList = new SaveCarList();

    public void run(List<Car> getCarName, int tryNumber) {
        this.tryNumber = tryNumber;
        printAll.outputResultPrint();

        List<Car> CarList = saveCarList.entireCarList();

        while (tryNumber > 0) {
            for (Car car : CarList) {
                trueOrFalse = ForwardOrNot(getRandomNumber);
                updateProgress(trueOrFalse);
            }
            printAll.printProgress(CarList);
            tryNumber--;
        }
        //Winner;
        printAll.outputFinalPrint(winner);

    }
}
