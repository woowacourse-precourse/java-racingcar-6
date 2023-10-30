package racingcar.view;

import racingcar.dto.request.ActionCountDto;
import racingcar.dto.request.CarNamesDto;
import racingcar.utility.Reader;
import racingcar.utility.Writer;

public class InputView {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ACTION_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    public CarNamesDto carNameRequest() {
        Writer.println(CAR_NAME_REQUEST_MESSAGE);
        return new CarNamesDto(Reader.readLine());
    }

    public ActionCountDto actionCountRequest() {
        Writer.println(ACTION_COUNT_REQUEST_MESSAGE);
        return new ActionCountDto(Reader.readLine());
    }
}
