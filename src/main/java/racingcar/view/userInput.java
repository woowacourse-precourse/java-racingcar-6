package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.Set;

public class userInput {

    public static List<String> getCarNames(){
        String carNames = readLine();
        List<String> nameList = Arrays.asList(carNames.split(","));

        validateNames(nameList);
        return nameList;
    }

    public static void validateNames(List<String> names){
        Set<String> setNames = new HashSet<>(names);

        if(setNames.size()!= names.size()){
            throw new IllegalArgumentException("차량이름이 중복되었습니다.");
        }

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5자를 넘지 않아야 합니다.");
            }
        }

    }

    public static void validateTryNumber(int tryNum){
        if(tryNum < 0 ){
            throw new IllegalArgumentException("시도 횟수는 0을 넘어야 합니다.");
        }

    }
    public static int getTryNumber(){
        int tryNum = Integer.parseInt(readLine());
        validateTryNumber(tryNum);
        return tryNum;

    }
    private static String readLine(){
        return Console.readLine();
    }

}
