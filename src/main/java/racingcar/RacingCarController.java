package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    static final int INPUT_RACING_CAR_LENGTH_LIMIT = 5;
    static final int TOTAL_TURN_MIN = 0;
    RacingCarService racingCarService = new RacingCarService();

    public void run(){
        try{
            List<String> racingCars = inputRacingCarName();
            int totalTurn = inputTotalTurn();
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        racingCarService.play();
    }

    public List<String> inputRacingCarName() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> inputRacingCars = new ArrayList<>();

        String[] racingCarInput = Console.readLine().split(",");

        for(String racingCar : racingCarInput) {
            if(racingCar.length() > INPUT_RACING_CAR_LENGTH_LIMIT || racingCar.isEmpty()){
                throw new IllegalArgumentException();
            }

            inputRacingCars.add(racingCar);
        }
        for(int i = 0; i < racingCarInput.length; i++){
            System.out.println(racingCarInput[i]);
        }
        return inputRacingCars;
    }

    public int inputTotalTurn() throws IllegalArgumentException{
        System.out.println("시도할 회수는 몇회인가요?");

        int inputTotalTurn = Integer.parseInt(Console.readLine());

        if(inputTotalTurn < TOTAL_TURN_MIN){
            throw new IllegalArgumentException();
        }
        return inputTotalTurn;
    }
}
