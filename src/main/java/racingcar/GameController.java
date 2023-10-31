package racingcar;

import static racingcar.GameLogic.decideMove;
import static racingcar.GameLogic.findMaxMove;
import static racingcar.GameLogic.findWinner;
import java.util.Arrays;

public class GameController {
    public static void gameStart(){
        String[] carNames = getCarName();
        Car[] carList = makeCars(carNames);

        int gameRound = getGameRound();
        playRound(gameRound, carList);

        resultGame(carList);
    }
    public static int getGameRound(){
        String inputRound = View.inputRound();
        InputValidator.checkRoundNumber(inputRound);
        int gameRound = Integer.parseInt(inputRound);
        InputValidator.checkNotNegative(gameRound);
        return gameRound;
    }

    public static void playRound(int gameRound, Car[] carList){
        for (int i = 0; i < gameRound; i++) {
            carMove(carList);
        }
    }
    public static String[] getCarName(){
        String inputCars = View.inputCarName();
        String[] cars = InputValidator.splitCarName(inputCars);
        InputValidator.checkNameLength(cars);
        InputValidator.checkNameNull(cars);
        return cars;
    }

    public static Car[] makeCars(String[] cars){
        return  Arrays.stream(cars)
                .map(Car::new)
                .toArray(Car[]::new);
    }

    public static void carMove(Car[] carList){
        for (Car car : carList) {
            if (decideMove()) {
                car.moveForward();
            }
            System.out.println(car.toString());
            }
        System.out.println();
    }

    public static void resultGame(Car[] carList){
        int finalMax = findMaxMove(carList);
        String result = findWinner(carList, finalMax);

        System.out.println("최종 우승자 : " + result);
    }
}
