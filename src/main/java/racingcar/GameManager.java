package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Validator validator = new Validator();

    public List<String> inputListCarsName(){
        String [] splitStr = inputStringCarsName().split(",");

        ArrayList<String> carsName = new ArrayList<String>();
        for(String name : splitStr){
            carsName.add(name);
        }

        checkValidationListCarNames(carsName);

        return carsName;
    }

    private void checkValidationListCarNames(List<String> input){
        try{
            validator.checkListCarNames(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private String inputStringCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        checkValidationStringCarNames(input);

        return input;
    }
    private void checkValidationStringCarNames(String input){
        try{
            validator.checkStringCarNames(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public int inputTrial(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        checkValidationTrial(input);

        return Integer.parseInt(input);
    }

    private void checkValidationTrial(String input){
        try{
            validator.checkTrial(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void findWinner(List <Car> cars){
        int bestPosition = 0;
        String judgment = "";
        for(Car car : cars){
            //bestPosition 보다 크거나 같을 때
            if(comparePosition(bestPosition,car.getPosition())){
                judgment = judge(judgment,bestPosition,car.getPosition(),car.getName());
                bestPosition = car.getPosition();
            }
        }
        System.out.println("최종 우승자 : " + judgment);
    }

    private boolean comparePosition(int bestPosition, int carPosition){
        if(bestPosition > carPosition){
            return false;
        }
        return true;
    }

    private String judge(String judgment, int bestPosition, int carPosition, String carName){
        if(bestPosition < carPosition){
            return carName;
        }
        return judgment + ", " + carName;
    }
}
