package racingcar;

import racingcar.domain.Judge;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class racingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingCars racingCars;

    public racingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void mainRun() {
        //차량이름 입력받아 준비
        createCar();

        //레이싱 반복 횟수 입력받아 반복실행
        runRacing();

        //결과 출력
        result();

    }

    private void createCar() {
        this.racingCars = new RacingCars(inputView.inputCarName());
    }

    private void runRacing() {
        int racingNum = inputView.inputRacingNum();
        racingLoop(racingNum);
    }

    private void racingLoop(int number) {
        for (int i = 0; i < number; i++) {
            racingCars.racingStepOne();
            outputView.racingNow(racingCars);
        }
    }

    private void result() {
        Judge judge = new Judge();
        outputView.printWinners(judge.getWinners(racingCars.getCars()));
    }

}
