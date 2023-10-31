package racingcar;

import java.util.List;

public class Controller {
    private static final String resultPrint = "실행 결과";
    public void raceStart(){
        User user = new User();
        user.setCarNames();
        int gameNumber = InputMessage.gameNumber();
        Racing racing = new Racing();
        racing.createRace(user.carNames);
        System.out.println(resultPrint);

        for(int i=0; i<gameNumber; i++){
            racing.racing(user.carNames);
            System.out.println();
        }

        racing.findWinner();
        OutputMessage outputMessage = new OutputMessage(racing.maxIndexs, user.carNames);
        outputMessage.winnerPrint();
    }
}
