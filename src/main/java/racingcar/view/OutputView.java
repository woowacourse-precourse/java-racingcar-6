package racingcar.view;

import java.util.List;
import racingcar.constant.RaceConstant;
import racingcar.dto.RaceResultResponse;
import racingcar.dto.WinnerResponse;
import racingcar.message.RaceMessage;

public class OutputView {
    public void printRaceResultMessage(){
        System.out.println();
        System.out.println(RaceMessage.RACE_RESULT_MESSAGE);
    }
    public void printRaceResult(RaceResultResponse response){
        List<String> cars = response.getCars();
        for (int i = RaceConstant.START_INDEX; i < cars.size(); i++) {
            printResultByCar(response.getRaceResult(), cars, i);
        }
        System.out.println();
    }
    public void printWinner(WinnerResponse winner){
        System.out.println(RaceMessage.WINNER + RaceConstant.COLON + String.join(RaceConstant.COMMA, winner.getWinner()));
    }

    private static void printResultByCar(List<Integer> raceResult, List<String> cars, int i) {
        System.out.print(cars.get(i) + RaceConstant.COLON);
        for (int j = RaceConstant.START_INDEX; j < raceResult.get(i); j++){
            System.out.print(RaceConstant.MOVE);
        }
        System.out.println();
    }
}