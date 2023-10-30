package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutView;

public class RacingCarGameController {

    public void settingRacingCarGame() {
        List<String> carNameList = InputView.inputRacingCarName();
        List<Car> carList = createRacingCar(carNameList);

        String racingRoundTimes = InputView.inputRacingRoundTimes();

        startGame(carList, racingRoundTimes);
    }

    public void startGame(List<Car> carList, String racingRoundTimes) {
        roundProgress(carList, Integer.parseInt(racingRoundTimes));
        caculateScore(carList);
    }

    public void caculateScore(List<Car> carList) {
        // 계산하는 부분
        OutView.printWinnerCar(carList);
    }

    public List<Car> createRacingCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public int makeRandomNumber() { // 랜덤번호 생성
        return Randoms.pickNumberInRange(0, 9);
    }

    public void roundProgress(List<Car> carList, int racingRoundTimes){
        System.out.println("실행결과");
        for(int i=0; i<racingRoundTimes; i++){
            decideGoOrStop(carList);
            OutView.printCurrentRoundResult(carList);
        }
    }

    public void decideGoOrStop(List<Car> carList){
        for (Car car : carList) {
            if(checkRandomNumber(makeRandomNumber())){
                car.plusStepCount();
            }
        }
    }

    public boolean checkRandomNumber(int num){
        if (num >= 4){
            return true;
        }
        return false;
    }
}
