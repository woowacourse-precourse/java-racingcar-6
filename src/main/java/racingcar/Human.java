package racingcar;
import static camp.nextstep.edu.missionutils.Console.*;
public class Human {
    static String[] getCommaSplittedWords(){
        String[] names = readLine().split(",");
        return names;
    }
    static int getInteger(){
        try{
            return Integer.parseInt(readLine());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해 주세요");
        }
    }
}
