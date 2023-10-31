package racingcar.service;

import racingcar.constant.AnnouncerScript;
import racingcar.domain.Car;
import racingcar.utility.ExceptionHandler;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.HashMap;
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
        carList = new Car(setCarName());

        output.printMessage(AnnouncerScript.ASK_NUMBER_OF_ATTEMPTS);
        setTryNumber();

        racing.play(carList, attemp);
    }

    private HashMap<String, Integer> setCarName() {
        String name = input.inputFromUser();
        HashMap<String, Integer> nameList = new HashMap<>();

        exceptionHandler.isBlank(name);

        StringTokenizer st = new StringTokenizer(name, ",");

        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            exceptionHandler.isExceedLength(carName);

            nameList.put(carName, 0);
        }

        return nameList;
    }

    private void setTryNumber() {
        String tryNumber = input.inputFromUser();

        exceptionHandler.isNumeric(tryNumber);

        attemp = Integer.parseInt(tryNumber);
        exceptionHandler.isNaturalNumber(attemp);
    }

}
