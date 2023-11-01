package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vo.CarInfo;
import racingcar.vo.RacingInfo;

import java.util.List;

public class RacingCarHandler implements Handler<RacingInfo, RacingInfo>{

    public RacingInfo execute(final RacingInfo racingInfo) {
        for(int i = 0; i< racingInfo.getRepeatCount(); i++){
            moveCar(racingInfo.getCarList());
        }
        return racingInfo;
    }

    private void moveCar(final List<CarInfo> carInfoList) {
        for (CarInfo carInfo : carInfoList) {
            moveCarAndPrint(carInfo);
        }
        System.out.println();
    }

    private void moveCarAndPrint(CarInfo carInfo) {
        if(Randoms.pickNumberInRange(0,9)>=4)
            carInfo.increaseMoveCnt();
        System.out.println(carInfo);
    }

}
