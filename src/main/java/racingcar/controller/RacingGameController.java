package racingcar.controller;

import org.w3c.dom.ls.LSInput;
import racingcar.my_io.MyInput;
import racingcar.utils.CarNameValidator;

import java.util.*;

import static java.util.Collections.*;

public class RacingGameController {
    private Car car;
    private CarNameValidator carNameValidator;
    private MyInput myInput;

    public RacingGameController(Car car,
                               CarNameValidator carNameValidator,
                               MyInput myInput) {
        this.car = car;
        this.carNameValidator = carNameValidator;
        this.myInput = myInput;
    }

    public void startGame() {
        String userInput = myInput.getCarNameList();
        // userInput에서 ","구분점으로 분리 후 userList에 담기
        Map<String, String> carMap = new Hashtable<>();
        String[] splitStr = userInput.split(",");
        for (int i = 0; i < splitStr.length; i++) {
            carMap.put(splitStr[i],"");
        }

        Integer tryTimes = Integer.valueOf(myInput.getTryTimes()); // 문자열 -> 정수 변환 입력 (정수형 아니면 오류)
        // 추후 문제시 테스트케이스 생각해보기

        checkUserNameValidate(carMap);

        System.out.println("실행 결과");
        carMap = Collections.<String, String>unmodifiableMap(executedResult(carMap, tryTimes));

        List<String> winnerList = getFinalWinnerList(carMap);

        System.out.print("최종 우승자 : ");
        for(int i=0; i<winnerList.size(); i++){
            System.out.print(winnerList.get(i));
            if((i+1) != winnerList.size()){
                System.out.print(", ");
            }
        }
    }

    public List<String> getFinalWinnerList(Map<String, String> carMap){
        List<String> winnerList = new ArrayList<>();
        Map<String,Integer> cntMap = new Hashtable<>();

        for(String carName : carMap.keySet()){
            String dist = carMap.get(carName);
            int cntDist = (int) dist.chars().filter(c -> c== '-').count();
            cntMap.put(carName, cntDist);
        }

        int maxNum = 0;
        for(String carName : cntMap.keySet()){
            int num = cntMap.get(carName);
            if(num > maxNum){
                maxNum = num;
            }
        }

        int finalMaxNum = maxNum;
        cntMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue()==finalMaxNum)
                .forEach(entry -> winnerList.add(entry.getKey()));

        return winnerList;
    }

    private Map<String, String> executedResult(Map<String, String> carMap, Integer tryTimes){
        final Map<String, String> resultMap = carMap;

        for(int times = 0; times < tryTimes; times++){
            for(String carName : resultMap.keySet()){
                String dist = resultMap.get(carName);
                if(car.isMoving()){
                    dist += '-';
                    resultMap.put(carName, dist);
                }
                System.out.println(carName + " : " + dist);
            }
            System.out.println();
        }

        return resultMap;
    }

    private boolean checkUserNameValidate(Map<String, String> carMap) {
        for (String carName : carMap.keySet()) {
            if (carNameValidator.isPossibleNameLength(carName)) {
                //System.out.println("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
