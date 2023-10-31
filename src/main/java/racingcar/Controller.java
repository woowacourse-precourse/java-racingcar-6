package racingcar;

import java.util.List;

public class Controller {
    private static final String resultPrint = "실행 결과";
    public void raceStart(){
        User user = new User();
        user.setCarNames();
        int gameNumber = Integer.parseInt(InputMessage.gameNumber());
        Racing racing = new Racing();
        racing.createRace(user.carNames);
        System.out.println(resultPrint);

        for(int i=0; i<gameNumber; i++){
            List<Integer> RandomNumberList = racing.raceRandomNumberList(user.carNames);
            racing.forwardValidation(RandomNumberList);
            OutputMessage.racePrint(racing.raceSituation);
            System.out.println();
        }

        racing.forwardCount(racing.raceSituation);
        racing.findMaxIndex(racing.forwardCountNumbers);
        OutputMessage outputMessage = new OutputMessage(racing.maxindexs, user.carNames);
        outputMessage.winnerPrint();
    }
}
