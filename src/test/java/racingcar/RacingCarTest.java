package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.CheckMoveAndStopTest.CheckMoveAndStop;

public class RacingCarTest {
    private List<StringBuilder> winCount = new ArrayList<>();
    private int maxCount = 0;

    @Test
    void gameStart(){
        OutputCarRace.print(MessageType.INPUT_CAR_NAME_PRINT);
        InputCarRace.inputCarNames("차이름1,차이름2,차이름3,차이름4");

        OutputCarRace.printf(MessageType.INPUT_CAR_RACING_COUNT_PRINT);
        InputCarRace.inputMove("2");
        System.out.println();

        OutputCarRace.print(MessageType.OUPUT_RACE_RESULT_PRINT);

        for (String carName : InputCarRace.getCarNumbers()) {
            this.winCount.add(new StringBuilder());
        }

        for (int i = 0; i < InputCarRace.getMoveCount(); i++) {
            for (int j = 0; j < InputCarRace.getCarNumbers().size(); j++) {
                if(CheckMoveAndStop.isMove()){
                    this.winCount.set(j,this.winCount.get(j).append("-"));

                    if(this.maxCount < winCount.get(j).length()){
                        this.maxCount = winCount.get(j).length();
                    }
                }

                OutputCarRace.printf(MessageType.OUPUT_IMPLEMENTATION_RESULT_PRINT, InputCarRace.getCarNumbers().get(j), this.winCount.get(j).toString());
            }
            System.out.println();
        }

        StringBuilder winners = new StringBuilder();

        for (int i = 0; i < winCount.size(); i++) {
            if(this.maxCount == winCount.get(i).length()){
                winners.append(InputCarRace.getCarNumbers().get(i)).append(", ");
            }
        }

        System.out.println("최종 우승자 : " + winners.substring(0,winners.length()-2));

    }
}
