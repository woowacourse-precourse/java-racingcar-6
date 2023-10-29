package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

//각 시행 별 자동차들 관리하는 컨트롤 Service
public class CarService {

    //2) 경주할 각 자동차별 '랜덤값' 에 따라 전진-멈춤 조건 판별 기능
    public boolean judgeRunOrStop() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            return true;
        }
        return false;
    }

    //3) 판별 결과에 따라 현재 상태 세팅
    public void setCurrentCar(boolean flag, Car car) {
        if (flag) { //전진 상태일 때만
            int carCount = car.getCount();
            car.setCount(carCount + 1);
        }
    }


}