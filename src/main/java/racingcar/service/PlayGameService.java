package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.RacingCarEntity;

import java.util.ArrayList;
import java.util.List;

public class PlayGameService {

    private final UserInputService userInputService;
    public PlayGameService() {
        userInputService = new UserInputService();
    }

    public void playGame(List<RacingCarEntity> cars, Integer tryCount) {
        for (int i = 0; i < tryCount; i++) moveAndPrint(cars);
    }

    public void moveAndPrint(List<RacingCarEntity> cars) {
        tryMoveCars(cars);
        printRoundResult(cars);
    }

    public void tryMoveCars(List<RacingCarEntity> cars) {
        for (RacingCarEntity car : cars) {
            if (isPassFour()) car.oneMove();
        }
    }


    public Boolean isPassFour() {
        Integer num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public void printRoundResult(List<RacingCarEntity> cars) {
        for (RacingCarEntity car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveCount()));
        }
        System.out.println();
    }


}
