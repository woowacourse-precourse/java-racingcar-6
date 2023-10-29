package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.CarList;
import racingcar.View.InputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class GameController {
    private InputView inputView;
    private CarList carList;
    private Validator validator;

    public GameController(){
        this.inputView = new InputView();
        this.carList = new CarList();
        this.validator = new Validator();
    }

    public void runGame(){
        List<String> carNameList = new ArrayList<>(this.inputView.inputCarNames());
        validator.validListIsEmpty(carNameList);
        String tryCount = this.inputView.inputCounts();
        fillCarList(carNameList);
    }

    private void fillCarList(List<String> carNameList){
        for(String carName : carNameList){
            validator.validCarName(carName);
            Car newCar = new Car(carName);
            carList.addCar(newCar);
        }
    }
    public void raceOnce(){

    }

    public int getRandomNumber(){
        int genNumber = Randoms.pickNumberInRange(0, 9);
        return genNumber;
    }

}
