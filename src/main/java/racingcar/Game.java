package racingcar;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Game {

    public void start(){
        //1. 사용자로부터 자동차 이름, 시도할 회수 입력받기
        String[] carNames = getCarNames();
        int tryCount = getTryCount();

    }

    public String[] getCarNames(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();

        if(!checkCarNames(inputCarNames)){
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        return inputCarNames.split(",");
    }

    public boolean checkCarNames(String carNames){
        if(carNames.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public int getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = readLine();

        if(!isNumeric(inputTryCount)){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

        return Integer.parseInt(inputTryCount);
    }

    public boolean isNumeric(String tryCount){
        try {
            Integer.parseInt(tryCount);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
