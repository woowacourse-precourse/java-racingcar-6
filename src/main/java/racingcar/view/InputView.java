package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_PROMPT = "시도할 회수는 몇회인가요?";

    public List<String> readCarName(){
        System.out.println(CAR_NAME_INPUT_PROMPT);
        String names = Console.readLine();

        return Arrays.stream(names.split(","))
                .collect(Collectors.toList());
    }

    public int readTryCount(){
        System.out.println(TRY_COUNT_INPUT_PROMPT);

        return readLineAndParseInt();
    }


    private int readLineAndParseInt(){
        try{
            return Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
        }
    }
}
