package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Controller {
    Validate validate = new Validate();
    CarList carList;
    public void putCarList(List<String> nameList){
        validate.validateName(nameList);
        // CarList 생성자 만들기 -> 여기에 저장을 하든지 해야지
        this.carList = new CarList(nameList);
        //THINK: 여기서 carlist를 넘겨주는게 맞는지
    }

    public int getHowMany(String strNumber){
        int number = 0;
        if (validate.validateNumber(strNumber)){
            number = parseInt(strNumber);
        }
        return number;
    }

    /* 입력한 수 만큼 반복 진행
    * 자동차 수 만큼 랜덤한 숫자 만들어서
    * 이걸 carList에 넘겨줌*/
    public void play(int howMany){
        OutputView outputView = new OutputView();
        while (howMany > 0){
            List<Integer> randomNums = new ArrayList<>();
            for (int i = 0; i< carList.getSize(); i++){
                randomNums.add(new Generator().generateRandomNumber());
            }
            List<Integer> zeroOne = validate.replaceZeroAndOne(randomNums);
            carList.upgradeDistance(zeroOne);
            outputView.printInterm(carList.toString());
            howMany--;
        }
    }

    public List<String> whoWinner(){
        return carList.getWinner();
    }

}
