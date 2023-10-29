package racingcar;

import java.util.HashMap;

public class RacingGame {

    private static final String REQUIRE_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUIRE_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PROGRESS_RESULT = "실행결과";
    private Player player = new Player();
    private HashMap<String, Integer> cars;
    private int attemptNumber;
    private int carNumber;

    public void GameStart(){
        printMessage(REQUIRE_CAR_NAME_MESSAGE);
        player.setCarName();
        printMessage(REQUIRE_ATTEMPT_NUMBER_MESSAGE);
        player.setAttemptNumber();
        attemptNumber = player.getAttemptNumber();

        cars = player.getCarName();
        carNumber = cars.size();

        gameProgress(attemptNumber);
    }

    public void gameProgress(int attemptNumber){
        printMessage(PROGRESS_RESULT);
        for(int i = 0; i<attemptNumber; i++){
            for(int j = 0; j<carNumber; j++){
                String carName = player.getCarName(j);
                eachCarPickRandomNumber(carName);
                printProgress(carName);
            }

        }
    }

    public void printProgress(String carName){
        System.out.printf("%s : ", carName);
        int valueOfCar = cars.get(carName);
        for(int i = 0; i<valueOfCar; i++){
            System.out.print("-");
        }
        System.out.println("\n");
    }

    public void eachCarPickRandomNumber(String carName){
        int randomNumber = player.getRandomNumber();
        if (randomNumber >= 4){
            int updateCarValue = cars.get(carName) + 1;
            cars.put(carName,updateCarValue);
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
