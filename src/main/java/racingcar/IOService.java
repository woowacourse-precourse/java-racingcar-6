package racingcar;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
public class IOService {
    static List<String> getCommaSplittedWords(){
        return Arrays.asList(
                readLine().split(",")
        );
    }
    static int getInteger(){
        try{
            return Integer.parseInt(readLine());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }
}
