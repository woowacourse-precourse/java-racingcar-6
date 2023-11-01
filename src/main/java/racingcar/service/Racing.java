package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    public static RacingService service = new RacingService();
    public static void racingStart(){
        OutputView.printStartMessage();
        List<String> racerNames = InputView.readRacerNames();
        validation.nameLengthExcept(racerNames);

        racerNames.stream().forEach(name -> service.join(name));

        OutputView.printTryMessage();
        int tryNumber = InputView.readTryNumber();
        racingRound(tryNumber,racerNames);
        List<String> winners = service.selectWinner(racerNames);
        OutputView.printFinMessage(winners);
    }

    public static void racingRound(int tryNum, List<String> racerNames){
        for(int i=0; i<tryNum; i++){
            racerNames.stream().forEach(name -> service.roundMove(name));
            racerNames.stream().forEach(name -> OutputView.printNameAndDashes(name,service.roundResult(name)));
            OutputView.printRoundFin();
        }
    }
}
