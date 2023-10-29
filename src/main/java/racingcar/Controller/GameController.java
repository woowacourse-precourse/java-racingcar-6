package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.CarList;
import racingcar.View.InputView;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.View.OutputView;

import java.util.List;
import java.util.ArrayList;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private List<Car> carList;
//    private CarList carList;
    private Validator validator;

    public GameController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carList = new ArrayList<>();
        this.validator = new Validator();
    }

    public void runGame(){
        String tryCount;
        int validCountNum;

        List<String> carNameList = new ArrayList<>(this.inputView.inputCarNames());
        validator.validListIsEmpty(carNameList);

        tryCount = this.inputView.inputCounts();
        validCountNum = validator.getValidNumber(tryCount);

        fillCarList(carNameList);
        this.outputView.printResultInit();

    }

    private void fillCarList(List<String> carNameList){
        for(String carName : carNameList){
            validator.validCarName(carName);
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }
    public void raceOnce(Car car){
        if(getRandomNumber() >= 4){
            car.addProgress();
        }
    }

    public int getRandomNumber(){
        int genNumber = Randoms.pickNumberInRange(0, 9);
        return genNumber;
    }
}
