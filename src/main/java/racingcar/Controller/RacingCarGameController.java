package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Util.InputValidator;
import racingcar.View.InputView;
import racingcar.View.OutView;

public class RacingCarGameController {

    public void initRacingCarGame() {
        List<String> carNameList = InputView.inputRacingCarName();
        List<Car> carList = createRacingCar(carNameList);

        String racingRoundTimes = InputView.inputRacingRoundTimes();

        roundProgress(carList, Integer.parseInt(racingRoundTimes)); // 게임 진행
        OutView.printWinnerCar(carList);
    }

    public List<Car> createRacingCar(List<String> carNameList) { // 나쁘지 않아 보임
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
