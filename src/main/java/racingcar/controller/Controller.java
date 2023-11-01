package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.repository.SaveCarList;
import racingcar.repository.UpdateProgress;
import racingcar.service.*;
import racingcar.view.PrintAll;



import java.util.List;
import java.util.logging.Logger;

public class Controller {
    private final InputCarName inputCarName;
    private final InputTryNumber inputTryNumber;
    private final GetRandomNumber getRandomNumber;
    private final PrintAll printAll;
    private final UpdateProgress updateProgress;
    private final Winner winner;
   // boolean trueOrFalse;
    private final SaveCarList saveCarList;
    private final ParsingCarName parsingCarName;
    CarList carListNew;
    int tryNumber;

    public Controller(InputCarName inputCarName, InputTryNumber inputTryNumber,
                      GetRandomNumber getRandomNumber, PrintAll printAll,
                      UpdateProgress updateProgress, Winner winner, ParsingCarName parsingCarName, SaveCarList saveCarList, CarList carList) {
        this.inputCarName = inputCarName;
        this.inputTryNumber = inputTryNumber;
        this.getRandomNumber = getRandomNumber;
        this.printAll = printAll;
        this.updateProgress = updateProgress;
        this.winner = winner;
        this.saveCarList=saveCarList;
        this.parsingCarName=parsingCarName;
        this.carListNew = carList; //수정 필요
        this.tryNumber = 0; // 초기값
  }

    //게임 시작
    public void start() {
        InputCarName inputCarName = new InputCarName();
        run(inputCarName.getCarName(), inputTryNumber.getTryNumber());
             }

    public void run(CarList carListNew, int tryNumber) {
        this.tryNumber = tryNumber;
        this.carListNew = carListNew;
        System.out.println(tryNumber);
        printAll.outputResultPrint(); //실행 결과
        System.out.println(tryNumber);

        //List<Car> CarList = saveCarList.entireCarList();
        //System.out.println(getCarName.get(0).getName());
        //System.out.println(getCarName.get(1).getName());
        //error: System.out.println(CarList.get(0));

        //System.out.println(carListNew.getCarList().get(0).getName());
        //System.out.println(carListNew.getCarList().get(1).getName());
        while (tryNumber > 0) {
            //System.out.println("hereTryNumber");
            for (Car car :carListNew.getCarList()) {

                //System.out.println("for문 car");
                boolean trueOrFalse = getRandomNumber.getTrueOrFalse();
                System.out.println(trueOrFalse);
                updateProgress.plusOrNot(car, trueOrFalse);
            }
            printAll.printProgress(carListNew.getCarList()); // 이부분이 안되고있음(racingcar.domain.Car@61a485d2 : racingcar.domain.Car@39fb3ab6 : - )

            System.out.println("전 tryNumber수는" + tryNumber);
            tryNumber--;
            System.out.println("후 tryNumber수는" + tryNumber);
        }
        //Winner;
        winner.finalResult(carListNew.getCarList());

    }
}
