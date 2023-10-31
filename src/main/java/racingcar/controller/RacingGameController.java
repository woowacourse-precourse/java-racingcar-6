package racingcar.controller;

import static java.lang.Integer.max;
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
        for(String s : getWinner()){
            System.out.println(s);
        }
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
    public List<String> getWinner(){
        int checkWinner = getMaxForward();
        List<String> result = resultList.getResultList();
        List<String> winners = new ArrayList<>();
        for(int i=0; i<result.size(); i++){
            if(result.get(i).length() == checkWinner){
                winners.add(carNameList.getCarNameList()[i]);
            }
        }
        return winners;
    }
    public int getMaxForward(){
        int maxNumber = 0;
        for(String s : resultList.getResultList()){
            maxNumber = max(maxNumber, s.length());
        }
        return maxNumber;
    }
}
