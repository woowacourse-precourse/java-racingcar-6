package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int championCount =0;
        List resultList = new ArrayList();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();
        validateException(userInput);
        List<String> userInputList = transUserInputToList(userInput);
        List<RacingCar> carList = getRacingCarNames(userInputList);

        System.out.println("시도할 횟수를 입력하세요.");
        int userTryInput = Integer.parseInt(readLine());

        for(int k=0;k<userTryInput;k++){
            //랜덤 값을 통해 전진
            for(RacingCar car : carList){
                int randomNum =Randoms.pickNumberInRange(0,9);
                if (randomNum>=4){
                    car.setCount(car.getCount()+"-");
                }
            }
        }
        for(int a=0;a<carList.size();a++){
            if(carList.get(a).getCount().length() > championCount){
                championCount=carList.get(a).getCount().length();
            }
            resultList.add(carList.get(a).getName() + " : " + carList.get(a).getCount());
        }
        List championList = new ArrayList();
        for(RacingCar car : carList){

            if(car.getCount().length()==championCount){
                championList.add(car.getName());
            }
        }
        String str = String.join(",", championList);
        resultList.add("최종 우승자 : "+str);
        System.out.println(resultList);
    }

    private static List<RacingCar> getRacingCarNames(List<String> userInputList) {
        List<RacingCar> carList = new ArrayList<>();
        for(int i = 0; i< userInputList.size(); i++){
            RacingCar racingCar = new RacingCar(userInputList.get(i),"");
            carList.add(racingCar);
        }
        return carList;
    }

    private static void validateException(String userInput) {
        if(userInput ==""){
            throw new IllegalArgumentException("입력된 값이 없습니다. 어플리케이션을 종료합니다.");
        }else if(validateOverlap(userInput)){
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다. 어플리케이션을 종료합니다.");
        }
    }

    private static List<String> transUserInputToList(String userInput) {
        List<String> userInputList = new ArrayList<>();
        for (String s : userInput.split(",")) {
            if (s.length()>=5){
                throw new IllegalArgumentException("String index out of range: 5");
/*                assertThatThrownBy(() -> s.charAt(5))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 5");*/
            }else{
                userInputList.add(s);
            }
        }
        return userInputList;
    }
    private static boolean validateOverlap (String userInput){
        Map<String, Integer> map = new HashMap<>();
        for (String c : userInput.split(",")) {
            map.put(c, map.getOrDefault(c, 0) + 1); // 중복되면 +1, 중복된것이 없으면 0 -> +1 해서 1
            if ((map.get(c) > 1)) {
                return true;
                //System.out.println("중복된 자동차 이름이 있습니다. 어플리케이션을 종료합니다.");
            }
        }
        return false;
    }
}
