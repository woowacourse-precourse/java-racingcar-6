package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static List<String> getCarNames() {
        String carNamesInput = Console.readLine();
        //Array보다는  Collections 사용! - 1주차 피드백

        List<String> carNamesInputList = convertInputToArrayList(carNamesInput);

        checkNameLengthException(carNamesInputList);

        return carNamesInputList;
    }

    public static int getTrialNumber() {
        int trialNumber = Integer.parseInt(Console.readLine());

        return trialNumber;
    }


    private static List<String> convertInputToArrayList(String carNamesInput){
        List<String> carNamesInputList = Arrays.asList(carNamesInput.split(","));

        return carNamesInputList;
    }


    public static void checkNameLengthException(List<String> carNamesInputList) {
        for (String carName : carNamesInputList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            }
        }
    }

}
