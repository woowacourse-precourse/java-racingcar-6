package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Car {
    Move m = new Move();
    public void carRacing(){
        List<String> carName = CarName();
        int move = m.getMove();
        System.out.println("실행 결과");
        m.printProgress(carName, move);
    }
    private List<String> CarName() {
        String[] carNameArray = getCarName().split(",");
        List <String> carNameList = new ArrayList<>();
        carNameList.addAll(Arrays.asList(carNameArray));
        if(!isNameLength(carNameList)){
            throw new IllegalArgumentException();
        }
        return carNameList;
    }
    private String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if(!isContainComma(input)){
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean isContainComma(String input){
        if(input.contains(","));{
            return true;
        }
    }
    private boolean isNameLength(List<String> carNameList){
        for(int i = 0; i < carNameList.size(); i++){
            String length = carNameList.get(i);
            if(length.length() < 4){
                return true;
            }
        }
        return false;
    }
}
