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
        Optional<String> checkedLine = illegalCheck.needConvertInteger(inputLine);

        if(!checkedLine.isPresent()){
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
        return Integer.parseInt(checkedLine.get());
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
