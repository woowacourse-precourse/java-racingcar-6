package racingcar.controller;

import racingcar.model.ForwardDecider;
import racingcar.model.GenerateAdvanceNumber;
import racingcar.model.RacingCar;
import racingcar.vailidation.Vailidator;
import racingcar.view.InputView;
import racingcar.view.outputView;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.Integer.parseInt;

public class RaceController {
    private static final String EXECUTION_RESULT = "실행결과";

    public static void start(){
        mainRace();
    }

    private static List<String> getCarNameToList(){
        List<String> carNames = Arrays.stream(getRacingCar().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        Vailidator.checkDuplicate(carNames);
        return carNames;
    }

    private static Map<String,String> generateNameWithString(){
        return RacingCar.generateCarNameWithStringHashMap(getCarNameToList());
    }

    private static int generateMatchCounts(){
        return parseInt(getMatchCounts()) ;
    }


    private static Map<String, Integer> generateCarNameWithRandomNumberHashMap(Map<String,String> nameWithString){
        List<Integer> randomNumber = GenerateAdvanceNumber.GenerateRandomNumber(nameWithString.size());
        List<String> names = new ArrayList<>(nameWithString.keySet());
        return RacingCar.generateCarNameWithRandomNumberHashMap(names,randomNumber);
    }


    public static String getRacingCar(){
        return InputView.enterRacingCarName();
    }

    public static String getMatchCounts(){
       return  InputView.enterMatchCounts();
    }
    private static void mainRace() {
        Map<String, String> nameWithString = generateNameWithString();
        int matchCounts = generateMatchCounts();

        System.out.println(EXECUTION_RESULT);
        Map<String, String> finalResult = race(nameWithString, matchCounts);
        List<String> winners = RacingCar.findWinners(finalResult);
        outputView.printWinners(winners);  // 경주 후 우승자를 출력
    }

    private static Map<String, String> race(Map<String, String> nameWithString, int matchCounts) {
        Map<String, String> result = new HashMap<>();
        for (int counts = 0; counts < matchCounts; counts++) {
            result = executeSingleRace(nameWithString);
            outputView.printOutput(result);
        }
        return result;
    }

    private static Map<String, String> executeSingleRace(Map<String, String> nameWithString) {
        Map<String, Integer> nameWithRandomNumber = generateCarNameWithRandomNumberHashMap(nameWithString);
        return ForwardDecider.decideForward(nameWithString, nameWithRandomNumber);
    }



}
