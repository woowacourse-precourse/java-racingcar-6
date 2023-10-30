package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;
import racingcar.model.gameinfo.RacingInfo;

public class GameService {

    private RacingInfo racingInfo;
    private List<CarInfo> carInfos;

    public void initializeGame(List<String> carNames, Integer maxRound) {
        this.carInfos = carNames
                .stream()
                .map(CarInfo::new)
                .toList();

        this.racingInfo = new RacingInfo(maxRound);
    }

    public RoundResult executeRound() {
        for (CarInfo carInfo : carInfos) {
            proceedCarRandomly(carInfo);
        }

        racingInfo.finishRound();

        return new RoundResult(carInfos);
    }

    public Winners findWinners() {
        int maxPosition = getMaxPosition();

        List<String> winnerNames = new ArrayList<>();
        for (CarInfo carInfo : carInfos) {
            addWinner(maxPosition, winnerNames, carInfo);
        }

        return new Winners(winnerNames);
    }

    public boolean isGameOver() {
        return racingInfo.getCurrentRound() > racingInfo.getMaxRound();
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

    private int getMaxPosition() {
        int maxPosition = 0;
        for (CarInfo carInfo : carInfos) {
            maxPosition = Math.max(maxPosition, carInfo.getCurrentPosition());
        }
        return maxPosition;
    }
}
