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
        List<String> resultList = new ArrayList<>();

        //자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();
        validateException(userInput);
        List<RacingCar> carList = getRacingCars(userInput);

        System.out.println("시도할 횟수를 입력하세요.");
        int userTryInput = Integer.parseInt(readLine());

        for(int tryCount=0;tryCount<userTryInput;tryCount++){
            //랜덤 값을 통해 전진
            movingForward(carList);
        }

        //자동차의 전진 현황 출력
        printForward(championCount, resultList, carList);
        //우승자 출력.
        printChampion(championCount, resultList, carList);
    }

    private static void printChampion(int championCount, List<String> resultList, List<RacingCar> carList) {
        //우승자 확인.
        List<String> championList = getChampionList(championCount, carList);
        String str = String.join(",", championList);
        resultList.add("최종 우승자 : "+str);
        System.out.println(resultList);
    }

    private static List<String> getChampionList(int championCount, List<RacingCar> carList) {
        //가장 많이 전진한 count 확인.
        championCount = checkChampionCount(championCount, carList);
        //우승자 확인
        return checkChampion(championCount, carList);
    }

    private static int checkChampionCount(int championCount, List<RacingCar> carList) {
        for(RacingCar racingCar : carList){
            if(racingCar.getCount().length() > championCount){
                championCount = racingCar.getCount().length();
            }
        }
        return championCount;
    }

    private static void printForward(int championCount, List<String> resultList, List<RacingCar> carList) {
        for(RacingCar racingCar : carList){
            resultList.add(racingCar.getName() + " : " + racingCar.getCount());
        }
    }

    private static List<RacingCar> getRacingCars(String userInput) {
        List<String> userInputList = transUserInputToList(userInput);
        return getRacingCarNames(userInputList);
    }

    private static List<String> checkChampion(int championCount, List<RacingCar> carList) {
        List<String> championList = new ArrayList<>();
        for(RacingCar car : carList){
            if(car.getCount().length()== championCount){
                championList.add(car.getName());
            }
        }
        return championList;
    }

    private static void movingForward(List<RacingCar> carList) {
        for(RacingCar car : carList){
            int randomNum =Randoms.pickNumberInRange(0,9);
            if (randomNum>=4){
                car.setCount(car.getCount()+"-");
            }
        }
    }

    private static List<RacingCar> getRacingCarNames(List<String> userInputList) {
        List<RacingCar> carList = new ArrayList<>();
        for(String carNames : userInputList){
            RacingCar racingCar = new RacingCar(carNames,"");
            carList.add(racingCar);
        }
        return carList;
    }

    private static void validateException(String userInput) {
        if(userInput.equals("")){
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
            }
        }
        return false;
    }
}
