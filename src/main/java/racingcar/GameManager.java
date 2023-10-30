package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Validator validator = new Validator();

    public List<String> inputCarsName(){
        String [] splitStr = inputStringCarsName().split(",");

        ArrayList<String> carsName = new ArrayList<String>();
        for(String name : splitStr){
            carsName.add(name);
        }

        return carsName;
    }

    public String inputStringCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return checkValidationCarNamesInput(input);
    }

    private String checkValidationCarNamesInput(String input){
        try{
            validator.checkCarNamesInput(input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputStringCarsName();
        }
    }

    public int inputTrial(){
        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(Console.readLine());
    }

    public void findWinner(List <Car> cars){
        int bestPosition = 0;
        String judgment = "";
        for(Car car : cars){
            //크거나 같을 때
            if(comparePosition(bestPosition,car.getPosition())){
                judgment = judge(judgment,bestPosition,car.getPosition(),car.getName());
                bestPosition = car.getPosition();
            }
        }

        System.out.println("최종 우승자 : " + judgment);
    }

    public boolean comparePosition(int bestPosition, int carPosition){
        if(bestPosition > carPosition){
            return false;
        }
        return true;
    }

    public String judge(String judgment, int bestPosition, int carPosition, String carName){
        if(bestPosition < carPosition){
            return carName;
        }
        return judgment + ", " + carName;
    }

}
