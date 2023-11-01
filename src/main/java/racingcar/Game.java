package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {

    private CarGroup carGroup;
    private int trialNumber;
    public Game() {
        initialize();
        run(carGroup.getCarList(), trialNumber);
        OutputHandler.printFinalResult(carGroup.getWinnerList());
    }

    private void initialize() {
        carGroup = initCarGroup();
        trialNumber = initTrialCount();
        System.out.println();
    }

    private CarGroup initCarGroup() {
        System.out.println(Constants.CARNAME_INPUT_MESSAGE);
        return new CarGroup(InputHandler.getCarListFromInput());
    }

    private int initTrialCount() {
        System.out.println(Constants.TRIALNUMBER_INPUT_MESSAGE);
        return InputHandler.getTrialNumberFromInput();
    }

    private void run(List<Car> carList, int trialNumber) {
        System.out.println(Constants.RESULT_MESSAGE);
        while (trialNumber > 0) {
            doTrial(carList);
            OutputHandler.printEachResult(carList);
            trialNumber--;
        }
    }

    private void doTrial(List<Car> carList) {
        for (Car car : carList) {
            int RandomNumber = getNumber();
            car.move(RandomNumber);
        }
    }

    private int getNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUMBER,Constants.MAX_RANDOM_NUMBER);
    }
}
