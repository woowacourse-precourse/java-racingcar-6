package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    static class RacingCar{
        private List<StringBuilder> winCount = new ArrayList<>();
        private int maxCount = 0;

        public void startGame(){
            inputData();
            compareCarName();
            printWinner();
        }

        private void inputData() {
            InputCarRace.init();
            OutputCarRace.print(MessageType.INPUT_CAR_NAME_PRINT);
            InputCarRace.inputCarNames(readLine());

            OutputCarRace.printf(MessageType.INPUT_CAR_RACING_COUNT_PRINT);
            InputCarRace.inputMove(readLine());
            setWinCount();
            System.out.println();
        }

        private void setWinCount(){
            for (String carName : InputCarRace.getCarNumbers()) {
                this.winCount.add(new StringBuilder());
            }
        }

        private void compareCarName() {
            OutputCarRace.print(MessageType.OUTPUT_RACE_RESULT_PRINT);

            for (int i = 0; i < InputCarRace.getMoveCount(); i++) {
                for (int j = 0; j < InputCarRace.getCarNumbers().size(); j++) {
                    if(CheckMoveAndStop.isMove()){
                        this.winCount.set(j,this.winCount.get(j).append("-"));

                        if(this.maxCount < winCount.get(j).length()){
                            this.maxCount = winCount.get(j).length();
                        }
                    }

                    OutputCarRace.printf(MessageType.OUTPUT_IMPLEMENTATION_RESULT_PRINT,
                            InputCarRace.getCarNumbers().get(j),
                            this.winCount.get(j).toString());
                }
                System.out.println();
            }
        }

        private void printWinner() {
            StringBuilder winners = new StringBuilder();

            for (int i = 0; i < winCount.size(); i++) {
                if(this.maxCount == winCount.get(i).length()){
                    winners.append(InputCarRace.getCarNumbers().get(i)).append(", ");
                }
            }

            OutputCarRace.printf(MessageType.OUTPUT_WINNERS, winners.substring(0,winners.length()-2));
        }
    }

    @Test
    void startGame(){
        new RacingCar().startGame();
    }
}
