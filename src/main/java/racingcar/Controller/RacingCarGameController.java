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
        InputValidator.checkCarNameLength(carNameList);
        String racingRoundTimes = InputView.inputRacingRoundTimes();
        InputValidator.checkIsNumber(racingRoundTimes);

        List<Car> carList = createRacingCar(carNameList);

        roundProgress(carList, Integer.parseInt(racingRoundTimes)); // 게임 진행
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
            for (Car car : carList) {
                if(checkRandomNumber(makeRandomNumber())){ // depth 신경쓸 것
                    car.plusStepCount();
                }
            }
            OutView.printCurrentRoundResult(carList);
        }
    }

    public boolean checkRandomNumber(int num){
        if (num >= 4){
            return true;
        }
        return false;
    }
}
