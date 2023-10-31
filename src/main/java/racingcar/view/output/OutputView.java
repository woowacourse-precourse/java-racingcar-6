package racingcar.view.output;

import java.util.List;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;

public class OutputView {

    public void printSeperator() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(RoundResult roundResult) {
        List<CarInfo> carInfos = roundResult.getCarInfos();

        for (CarInfo carInfo : carInfos) {
            System.out.println(getCarRoundResultString(carInfo));
        }

        System.out.println();
    }

    public void printWinner(Winners winners) {
        List<String> winnerList = winners.getWinnerList();

        String winnersString = String.join(", ", winnerList);

        System.out.println("최종 우승자 : " + winnersString);
    }

    private String getCarRoundResultString(CarInfo carInfo) {
        return carInfo.getCarName() + " : " + buildCarPositionString(carInfo);
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
