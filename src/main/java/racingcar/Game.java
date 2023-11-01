package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {
    private final static String INIT_CARGROUP_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INIT_TRIALNUMBER_TEXT = "시도할 회수는 몇회인가요?";
    private final static String TRIAL_RESULT = "실행 결과";
    private CarGroup carGroup;
    private int trialNumber;
    public Game() {
        this.carGroup = initCarGroup();
        this.trialNumber = initTrialCount();
        run(carGroup.getCarList(), trialNumber);
        OutputHandler.printFinalResult(carGroup.getWinnerList());
    }

    public CarGroup initCarGroup() {
        System.out.println(INIT_CARGROUP_TEXT);
        return new CarGroup(InputHandler.getCarListFromInput());
    }

    public int initTrialCount() {
        System.out.println(INIT_TRIALNUMBER_TEXT);
        return InputHandler.getTrialNumberFromInput();
    }

    public void run(List<Car> carList, int trialNumber) {
        System.out.println(TRIAL_RESULT);
        while (trialNumber > 0) {
            doTrial(carList);
            OutputHandler.printEachResult(carList);
            trialNumber--;
        }
    }

    public void doTrial(List<Car> carList) {
        for (Car car : carList) {
            int RandomNumber = getNumber();
            car.move(RandomNumber);
        }
    }
}
