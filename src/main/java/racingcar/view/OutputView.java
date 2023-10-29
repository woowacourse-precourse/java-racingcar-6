package racingcar.view;

import java.util.List;
import racingcar.dto.RaceResultResponse;
import racingcar.message.RaceMessage;

public class OutputView {
    public void printRaceResultMessage(){
        System.out.println();
        System.out.println(RaceMessage.RACE_RESULT_MESSAGE);
    }
}
