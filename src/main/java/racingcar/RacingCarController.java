package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    static final int INPUT_RACING_CAR_LENGTH_LIMIT = 5;
    static final int TOTAL_TURN_MIN = 0;
    static final int FIRST_MOVE_COUNT = 0;
    RacingCarService racingCarService = new RacingCarService();

    public void run(){
        try{
            List<RacingCar> racingCars = inputRacingCarName();
            int totalTurn = inputTotalTurn();

            racingCarService.play(racingCars, totalTurn);
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public List<RacingCar> inputRacingCarName() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<RacingCar> inputRacingCars = new ArrayList<>();

        String[] racingCarInput = Console.readLine().split(",");

        for(String racingCar : racingCarInput) {
            if(racingCar.length() > INPUT_RACING_CAR_LENGTH_LIMIT || racingCar.isEmpty()){
                throw new IllegalArgumentException();
            }

            RacingCar temporalRacingCar = new RacingCar();

            temporalRacingCar.setName(racingCar);

            temporalRacingCar.setMoveCount(FIRST_MOVE_COUNT);

            inputRacingCars.add(temporalRacingCar);
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