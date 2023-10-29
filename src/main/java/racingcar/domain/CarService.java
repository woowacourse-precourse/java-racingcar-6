package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 최종 우승자 판별 기능
     */
    //4) 최종 우승자의 max Score 찾는 함수
    public int getMaxScore(List<Car> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).getCount());
        }
        return max;
    }

    //5) 최종 우승자 이름 리턴 함수
    public List<String> getWinnerName(List<Car> list, int max) {
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i).getCount()) {
                winner.add(list.get(i).getCarName());
            }
        }
        return winner;
    }
}