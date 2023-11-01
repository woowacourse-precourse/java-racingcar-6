package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.error.InputError;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.message.Message.*;

public class RacingCarService {
    public static int tryCount;
    public static List<RacingCar> racingCars = new ArrayList<RacingCar>();
    public static List<String> winners = new ArrayList<String>();

    public static void runGame(){
        System.out.println(GAME_START_MESSAGE.getMessage());
        setCars(readLine());
        setTryCount();
        for(int i =0;i<tryCount;i++){
            playRacing();
            getResult();
        }
        checkWinner();
        getWinner(winners);
    }
    public static void setCars(String names){
        for(String name : names.split(",")){
            InputError.checkInputCar(name);
            racingCars.add(new RacingCar(name));
        }
    }

    public static void setTryCount(){
        System.out.println(CHECK_TRY_MESSAGE.getMessage());
        tryCount = Integer.parseInt(readLine());
    }

    public static void playRacing(){
        for(RacingCar car : racingCars) {
            car.checkMove();
        }
    }
    public static void getResult(){
        for(RacingCar car : racingCars){
            printPlayerScore(car);
        }
    }

//    public static List<String> getRacingCarNames() {
//        return racingCarNames;
//    }

    public static void printPlayerScore(RacingCar car){
        System.out.print(car.getCarName() + " : ");
        for(int i = 0; i< car.getScore(); i++){
            System.out.print("-");
        }
        System.out.println("");
    }

    public static List<String>checkWinner(){
//        List<String> winners = new ArrayList<String>();
        int highScore = 0;
        for(RacingCar racingCar : racingCars){
            if(racingCar.getScore() > highScore){
                highScore = racingCar.getScore();
            }
        }
        for(RacingCar racingCar : racingCars){
            if(racingCar.getScore() == highScore){
                winners.add(racingCar.getCarName());
            }
        }
        return winners;
    }

    public static void getWinner(List<String> winners){
        if(winners.size() ==1){
            System.out.println(PRINT_WINNER.getMessage());
            System.out.println(winners.get(0));
            System.out.println();
        }
        if(winners.size() != 1) {
            System.out.println(PRINT_WINNER.getMessage());
            for (int i = 0; i < winners.size(); i++) {
                System.out.println(winners.get(i));
                if (i != winners.size() - 1) {
                    System.out.println(", ");
                }
            }
        }
        System.out.println();
    }
}
