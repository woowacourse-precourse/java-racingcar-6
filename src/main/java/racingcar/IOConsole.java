package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import util.Messages;
import util.Validator;

import java.util.List;


public class IOConsole {


    public static List<String> readCarNames(){
        System.out.println(Messages.CAR_NAME_INPUT);
        return Validator.validateCarNames(Console.readLine());
    }

    public static int readTrial(){
        System.out.println(Messages.TRIAL_INPUT);
        return Validator.validateTrial(Console.readLine());
    }

    public static void printScores(List<Car> cars){
        for (Car currentCar : cars) {
            System.out.printf("%s : %s%n", currentCar.getName(), parseScoreToMark(currentCar.getScore()));
        }
    }
    private static String parseScoreToMark(int score){
        return "-".repeat(score);
    }
    public static void printWinner(List<String> winners){
        System.out.printf(String.valueOf(Messages.INFO_END));
        System.out.println(String.join(",", winners));
    }
}
