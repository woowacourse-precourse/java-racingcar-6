package racingcar.view.output;

import java.util.List;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;

public class OutputView {

    public void printRoundResult(RoundResult roundResult) {
        List<CarInfo> carInfos = roundResult.getCarInfos();

        for (CarInfo carInfo : carInfos) {
            String carString = carInfo.getCarName() + " : " + buildCarPositionString(carInfo);
            System.out.println(carString);
        }

        System.out.println();
    }

    public void printWinner(Winners winners) {
        List<String> winnerList = winners.getWinnerList();

        String winnersString = String.join(", ", winnerList);

        System.out.println("최종 우승자 : " + winnersString);
    }

    private String buildCarPositionString(CarInfo carInfo) {
        int position = carInfo.getCurrentPosition();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }

        return result.toString();
    }
}
