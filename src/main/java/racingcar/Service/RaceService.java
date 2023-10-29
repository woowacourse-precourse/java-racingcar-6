package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import racingcar.domain.Car;

public class RaceService {

    Car car=new Car();
    private int requestAttempts(){
        String attemptsInput = Console.readLine();
        return validateConvertToInt(attemptsInput);
    }

    private static int validateConvertToInt(String attemptsInput) {
        try {
            return Integer.parseInt(attemptsInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력하십시오.");
        }
    }

    private List<String> requestCarNames(){
        String carListInput = Console.readLine();
        StringTokenizer st=new StringTokenizer(carListInput,",");
        Set<String> tokenSet=new HashSet<>();
        while(st.hasMoreTokens()){
            String carName = validateDelimiter(st);
            validateDuplication(tokenSet, carName);
            car.addCarName(carName);
        }
        return car.getCarNameList();
    }

    private static void validateDuplication(Set<String> tokenSet, String carName) {
        if(!tokenSet.add(carName)){
            throw new IllegalArgumentException("차 이름이 중복되었습니다.");
        }
    }

    private static String validateDelimiter(StringTokenizer st) {
        String carName = st.nextToken();
        String[] token=carName.split("[^a-zA-Z0-9]+");
        if(token.length>1){
            throw new IllegalArgumentException("쉼표(,)를 기준으로 구분하여 입력하십시오.");
        }
        return carName;
    }
}
