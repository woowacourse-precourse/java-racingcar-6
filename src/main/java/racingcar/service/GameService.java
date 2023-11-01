package racingcar.service;

import racingcar.constant.AnnouncerScript;
import racingcar.domain.Car;
import racingcar.utility.ExceptionHandler;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GameService {

    private Output output = Output.getOutput();
    private Input input = Input.getInput();
    private ExceptionHandler exceptionHandler = ExceptionHandler.getExceptionHandler();
    private Racing racing;

    private Car carList;
    private int attemp;

    public GameService() {
        racing = new Racing();
    }

    public void start() {
        output.printMessage(AnnouncerScript.START_MENTION);
        setCarName();
        output.printMessage(AnnouncerScript.CREATE_CAR_NAME);

        output.printMessage(AnnouncerScript.ASK_NUMBER_OF_ATTEMPTS);
        setTryNumber();
        String formattingType = String.format(AnnouncerScript.DECIDE_NUMBER_OF_ATTEMPT, attemp);
        output.printMessage(formattingType);

        racing.play(carList, attemp);
    }

    private void setCarName() {
        String name = input.inputFromUser();
        List<String> carNames = new ArrayList<>();

        exceptionHandler.isBlank(name);
        exceptionHandler.isContainSpaces(name);

        StringTokenizer st = new StringTokenizer(name, ",");

        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            exceptionHandler.isExceedLength(carName);

            carNames.add(carName);
        }

        exceptionHandler.isDuplicationName(carNames);

        carList = new Car(carNames);
    }

    private void setTryNumber() {
        String tryNumber = input.inputFromUser();

        exceptionHandler.isNumeric(tryNumber);

        attemp = Integer.parseInt(tryNumber);
        exceptionHandler.isNaturalNumber(attemp);
    }

}
