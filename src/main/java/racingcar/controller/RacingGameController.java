package racingcar.controller;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarNameList;
import racingcar.model.ResultList;

public class RacingGameController {
    private static CarNameList carNameList;
    private static ResultList resultList;
    private static Integer tryNumber;
    public void init(){
        carNameList = CarNameList.getInstance(getCarString());
        carNameList.PrintCarName();
        tryNumber = getTryNumber();

        resultList = ResultList.getInstance(getResultList());
        resultList.PrintResult();

        for(int i=0; i<tryNumber; i++){
            MovingCar();
        }
        resultList.PrintResult();
    }
    public void MovingCar(){
        List<String> result = resultList.getResultList();
        for(int i=0; i<result.size(); i++){
            MovingForward(i, result);
        }
    }
    public void MovingForward(int idx, List<String> result){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            result.set(idx, result.get(idx)+"-");
        }
    }
    public String[] getCarString(){
        String carName = Console.readLine();
        return carName.split(",");
    }
    public Integer getTryNumber(){
        Integer inputNumber = parseInt(Console.readLine());
        return inputNumber;
    }
    public List<String> getResultList(){
        List<String> resultList = new ArrayList<>();
        for(int i=0; i< carNameList.getCarCount(); i++){
            resultList.add("");
        }
        return resultList;
    }
}
