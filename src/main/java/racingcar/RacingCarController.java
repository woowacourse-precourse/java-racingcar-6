package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    RacingCarService racingCarService = new RacingCarService();

    public void start(){
        try{
            List<String> racingCars = inputRacingCarName();
            int totalTurn = inputTotalTurn();
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        racingCarService.play();
    }

    private List<String> inputRacingCarName() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> inputRacingCars = new ArrayList<>();

        String[] racingCarInput = Console.readLine().split(",");

        for(String racingCar : racingCarInput) {
            if(racingCar.length() > 5 || racingCar.isEmpty()){
                throw new IllegalArgumentException();
            }

            inputRacingCars.add(racingCar);
        }

        return inputRacingCars;
    }

    private int inputTotalTurn() throws IllegalArgumentException{
        System.out.println("시도할 회수는 몇회인가요?");

        int inputTotalTurn = Integer.parseInt(Console.readLine());

        if(inputTotalTurn < 0){
            throw new IllegalArgumentException();
        }
        return inputTotalTurn;
    }
}
