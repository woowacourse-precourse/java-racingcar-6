package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Util.InputValidator;
import racingcar.View.InputView;

public class RacingCarGameController {

    public void initRacingCarGame() {
        List<String> carNameList = InputView.inputRacingCarName();
        InputValidator.checkCarNameLength(carNameList);
        String racingRoundTimes = InputView.inputRacingRoundTimes();
        InputValidator.checkIsNumber(racingRoundTimes);

        List<Car> carList = createRacingCar(carNameList);

        roundProgress(carList, Integer.parseInt(racingRoundTimes)); // 게임 진행
        createRacingCar(carNameList);
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
        for(int i=0; i<racingRoundTimes; i++){
            for (Car car : carList) {
                if(checkRandomNumber(makeRandomNumber())){
                    car.plusStepCount();
                }
            }

        }
        for (Car car : carList) {
            System.out.println(car.getName() + ": " + car.getStepCount());
        }
    }

    public boolean checkRandomNumber(int num){
        if (num >= 4){
            return true;
        }
        return false;
    }
}
