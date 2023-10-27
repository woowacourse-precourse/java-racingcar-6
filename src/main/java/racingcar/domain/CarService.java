package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.view.UserInput;

//각 시행 별 자동차들 관리하는 컨트롤 Service
public class CarService {
    public UserInput input;
    public ArrayList<Car> carList;

    public CarService(UserInput input) {
        this.input = input;
        this.carList = changeUserInputToCarList(input);
    }

    //1) 입력받은 자동차 이름별 Car 클래스 생성 및 리스트에 담기
    public ArrayList<Car> changeUserInputToCarList(UserInput input) {
        ArrayList<Car> list = new ArrayList<>();
        String[] tmp = input.userInputCarName.split(",");
        //각 자동차 이름별로 Car 클래스 리스트에 담고 초기화
        for (int i = 0; i < tmp.length; i++) {
            list.add(new Car((tmp[i]), 0));
        }
        return list;
    }

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
            car.count++;//++처리
        }
    }

    /**
     * 최종 우승자 판별 기능
     */
    //4) 최종 우승자의 max Score 찾는 함수
    public int getMaxScore(ArrayList<Car> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).count);
        }
        return max;
    }

    //5) 최종 우승자 이름 리턴 함수
    public ArrayList<String> getWinnerName(ArrayList<Car> list, int max) {
        ArrayList<String> winner = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i).count) {
                winner.add(list.get(i).carName);
            }
        }
        return winner;
    }
}