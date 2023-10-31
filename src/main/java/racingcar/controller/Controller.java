package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.CarList;
import racingcar.inputView.Input;
import racingcar.outputView.Output;
import racingcar.util.Invalidate;

public class Controller {
    private static CarList carList;

    public void initCarName() {
        Input.inputCarName();
        String[] cars = Console.readLine().split(",");

        checkInvalidate(cars);
        carList = new CarList(cars);
    }

    public int initTrial() {
        Input.inputTrial();
        String trial = Console.readLine();
        Invalidate.checkNumber(trial);

        return Integer.parseInt(trial);
    }

    public void execute(int trial) {
        Output.executeResult();

        for (int i = 0; i < trial; i++) {
            carList.printExecuteCarsMove();
        }
    }

    public void printResult() {
        String[] winnerList = carList.printWinnerList();

        Output.winnerResult();

        for (int i = 0; i < winnerList.length; i++) {
            if (i != winnerList.length - 1) {
                System.out.print(" " + winnerList[i] + ",");
                continue;
            }
            System.out.print(" " + winnerList[i]);
        }
    }

    public void checkInvalidate(String[] carsName) {
        Invalidate.checkNameDuplicate(carsName);
        Invalidate.checkNameLength(carsName);
        Invalidate.checkNameGap(carsName);
    }

}
