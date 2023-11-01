package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vo.CarInfo;
import racingcar.vo.RacingInfo;

import java.util.List;

class RacingCarHandler implements Handler<RacingInfo>{

    private static final String RACING_PERIOD_MESSAGE = "실행 결과";

    RacingCarHandler() {
    }

    public void execute(final RacingInfo racingInfo) {
        System.out.println(RACING_PERIOD_MESSAGE);
        for(int i = 0; i< racingInfo.getRepeatCount(); i++){
            moveCar(racingInfo.getCarList());
        }
    }

    private void moveCar(final List<CarInfo> carInfoList) {
        for (CarInfo carInfo : carInfoList) {
            moveCarAndPrint(carInfo);
        }
        System.out.println();
    }

    private static void moveCarAndPrint(CarInfo carInfo) {
        if(Randoms.pickNumberInRange(0,9)>=4)
            carInfo.increaseMoveCnt();
        System.out.println(carInfo);
    }

}
