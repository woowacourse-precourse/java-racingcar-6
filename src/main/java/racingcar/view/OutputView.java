package racingcar.view;

import java.util.List;
import racingcar.constant.RaceConstant;
import racingcar.dto.RaceProgressResponse;
import racingcar.dto.WinnerResponse;
import racingcar.message.RaceMessage;

public class OutputView {
    public void printRaceProgressMessage(){
        System.out.println();
        System.out.println(RaceMessage.RACE_RESULT_MESSAGE);
    }
    public void printRaceResult(RaceProgressResponse response){
        List<String> cars = response.getCars();
        for (int i = 0; i < cars.size(); i++) {
            printResultByCar(response.getRaceProgress(), cars, i);
        }
        System.out.println();
    }
    public void printWinner(WinnerResponse winner){
        System.out.println(RaceMessage.WINNER + " : " + String.join(", ", winner.getWinner()));
    }

    private static void printResultByCar(List<Integer> raceResult, List<String> cars, int i) {
        System.out.print(cars.get(i) + " : ");
        for (int j = 0; j < raceResult.get(i); j++){
            System.out.print(RaceConstant.MOVE);
        }
        System.out.println();
    }
}