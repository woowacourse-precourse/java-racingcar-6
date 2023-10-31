package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;
import racingcar.model.gameinfo.RoundInfo;

public class GameService {

    public RoundResult executeRound(RoundInfo roundInfo, List<CarInfo> carInfos) {
        for (CarInfo carInfo : carInfos) {
            proceedCarRandomly(carInfo);
        }

        roundInfo.finishRound();

        return new RoundResult(carInfos);
    }

    public Winners findWinners(List<CarInfo> carInfos) {
        int maxPosition = getMaxPosition(carInfos);

        List<String> winnerNames = new ArrayList<>();
        for (CarInfo carInfo : carInfos) {
            addWinner(maxPosition, winnerNames, carInfo);
        }

        return new Winners(winnerNames);
    }

    public boolean isGameOver(RoundInfo roundInfo) {
        return roundInfo.getCurrentRound() > roundInfo.getMaxRound();
    }

    private void proceedCarRandomly(CarInfo carInfo) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carInfo.proceed();
        }
    }

    private void addWinner(int maxPosition, List<String> winnerNames, CarInfo carInfo) {
        if (carInfo.getCurrentPosition() == maxPosition) {
            winnerNames.add(carInfo.getCarName());
        }
    }

    private int getMaxPosition(List<CarInfo> carInfos) {
        int maxPosition = 0;
        for (CarInfo carInfo : carInfos) {
            maxPosition = Math.max(maxPosition, carInfo.getCurrentPosition());
        }
        return maxPosition;
    }
}
