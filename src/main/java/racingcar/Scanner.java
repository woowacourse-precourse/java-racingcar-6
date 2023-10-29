package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Scanner {
    private int minimumOfRange;
    private int maximumOfRange;
    private int numberOfCars;
    private String delimiter;

    Scanner(Configurations configurations){
        minimumOfRange = configurations.getMinimumOfRange();
        maximumOfRange = configurations.getMaximumOfRange();
        numberOfCars = configurations.getNumberOfNumbers();
        delimiter = configurations.getDelimiter();
    }
    List<String> inputCarNames(){
        List<String>carNames = new ArrayList<>();
        String inputString = Console.readLine();
        StringTokenizer tokenizedInputString = new StringTokenizer(inputString,delimiter);
        while (tokenizedInputString.hasMoreTokens()) {
            String nextCar = tokenizedInputString.nextToken();
            carNames.add(nextCar);
        }
        return carNames;
    }
    Integer inputNumberOfRound(){
        Integer numberOfRound = Integer.parseInt(Console.readLine());
        return numberOfRound;
    }
}
