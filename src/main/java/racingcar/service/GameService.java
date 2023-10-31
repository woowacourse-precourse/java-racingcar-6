package racingcar.service;

import racingcar.constant.AnnouncerScript;
import racingcar.domain.CarDTO;
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

    private List<CarDTO> carList = new ArrayList<>();

    public GameService() {
    }

    public void start() {
        output.printMessage(AnnouncerScript.START_MENTION);

        setCarName();
    }

    private void setCarName() {
        String nameList = input.inputFromUser();

        exceptionHandler.isBlank(nameList);

        StringTokenizer st = new StringTokenizer(nameList, ",");

        while(st.hasMoreTokens()) {
            String carName = st.nextToken();
            exceptionHandler.isExceedLength(carName);

            carList.add(new CarDTO(carName));
        }
    }

   

    private void play() {

    }

}
