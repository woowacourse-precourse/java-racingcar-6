package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringConverter {
    private final IllegalCheck illegalCheck = new IllegalCheck();
    private final String ERROR_MESSAGE = "잘못된 값이 입력되었습니다.";

    public int stringToInteger(){
        String inputLine = Console.readLine();
        if(!inputLine.chars().allMatch(illegalCheck::availableConvertInteger)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        long integerRangeCheck = Long.parseLong(inputLine);

        if(!illegalCheck.integerRangeOverCheck(integerRangeCheck)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return Integer.parseInt(inputLine);
    }

    public List<String> stringToCarNames(String separator){
        String inputLine = Console.readLine();
        List<String> splittedNames = Arrays.stream(inputLine.split(separator)).toList();

        if(splittedNames.stream().anyMatch(illegalCheck::stringLengthOverCheck)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return splittedNames;
    }

}
