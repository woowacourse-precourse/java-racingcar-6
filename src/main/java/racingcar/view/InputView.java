package racingcar.view;

import static racingcar.constants.GameMessage.ACTION_COUNT_REQUEST_MESSAGE;
import static racingcar.constants.GameMessage.CAR_NAME_REQUEST_MESSAGE;

import racingcar.dto.request.ActionCountDto;
import racingcar.dto.request.CarNamesDto;
import racingcar.utility.Reader;
import racingcar.utility.Writer;

public class InputView {
    public CarNamesDto carNameRequest() {
        Writer.println(CAR_NAME_REQUEST_MESSAGE);
        return new CarNamesDto(Reader.readLine());
    }

    public ActionCountDto actionCountRequest() {
        Writer.println(ACTION_COUNT_REQUEST_MESSAGE);
        return new ActionCountDto(Reader.readLine());
    }
}
