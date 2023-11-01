package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import racingcar.domain.UserCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private OutputView outputView = new OutputView();
    private int roundNumber;
    private UserCar userCar = new UserCar();
    private InputView inputView = new InputView();
    public void generateCarNumber() {
        int number;
        for (String key : userCar.car.keySet()) {
            number = Randoms.pickNumberInRange(0, 9);
            decideForward(number, key);
        }
    }
    public void decideForward(int number, String key){
        if(number>4) {
            userCar.car.put(key, userCar.car.get(key) + 1);
        }
    }
    public void game(){
        userCar.inputCarName();
        this.roundNumber = inputView.inputRoundNumber();

        System.out.println("실행결과");
        for(int i=0; i<roundNumber; i++){
            generateCarNumber();
            outputView.currentLocation(userCar.car);
            System.out.println("");
        }
    }

}
