package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.InputManager;
import racingcar.Validator;

import java.util.ArrayList;
import java.util.List;

public class MainCarGame {
    CarManager carManager = new CarManager();
    ScorePrinter scorePrinter = new ScorePrinter();
    InputManager inputManager = new InputManager();
    public static int ATTEMPT_COUNT = 0;
    public static List<String> carOrderList;
    static final String MSG_MIDTERM = "실행 결과";

    public void gameStart() {
        setInput();

        System.out.println(MSG_MIDTERM);
        for (int i = 0; i < ATTEMPT_COUNT; i++) {
            carManager.setCarRandomNumber();
            scorePrinter.printMidtermScore();
        }
        scorePrinter.printFinalScore();
    }

    private void setInput() { //+유효검사
        Validator validator = new Validator();

        carOrderList = inputManager.getCarNameInput(); //List<String
        validator.validatorForCar(carOrderList); //유효검사는 객체생성보다 먼저되어야함
        carManager.initCar(carOrderList); //객체 생성

        ATTEMPT_COUNT = inputManager.getAttemptCountInput();
        validator.validatorForAttemptCount(ATTEMPT_COUNT);
    }

}
