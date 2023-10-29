package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.CheckMoveAndStopTest.CheckMoveAndStop;

public class RacingCarTest {
    private List<StringBuilder> winCount = new ArrayList<>();

    @Test
    void gameStart(){
        OutputCarRace.print(MessageType.INPUT_CAR_NAME_PRINT);
        InputCarRace.inputCarNames("차이름1,차이름2,차이름3,차이름4");

        OutputCarRace.printf(MessageType.INPUT_CAR_RACING_COUNT_PRINT);
        InputCarRace.inputMove("2");
        OutputCarRace.print(MessageType.OUPUT_RACE_RESULT_PRINT);

        for (String carName : InputCarRace.getCarNumbers()) {
            winCount.add(new StringBuilder());
        }

        for (int i = 0; i < InputCarRace.getMoveCount(); i++) {
            for (int j = 0; j < InputCarRace.getCarNumbers().size(); j++) {
                if(CheckMoveAndStop.isMove()){
                    winCount.set(j,winCount.get(j).append("-"));
                }

                OutputCarRace.printf(MessageType.OUPUT_IMPLEMENTATION_RESULT_PRINT, InputCarRace.getCarNumbers().get(j), winCount.get(j).toString());
            }
            System.out.println();
        }


    }
}
