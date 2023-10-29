package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Optional;

public class StringConverter {
    private final IllegalCheck illegalCheck = new IllegalCheck();

    public int stringToInteger(){
        String inputLine = Console.readLine();
        Optional<String> checkedLine = illegalCheck.needConvertInteger(inputLine);

        if(!checkedLine.isPresent()){
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
        return Integer.parseInt(checkedLine.get());
    }

}
