package racingcar.controller;

import racingcar.domain.Car;
import racingcar.utils.CarValidator;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarController {

    private Car car;
    private CarValidator carValidator;
    private RacingCarView carView;

    public RacingCarController(Car car,
                               CarValidator carValidator,
                               RacingCarView carView) {
        this.car = car;
        this.carValidator = carValidator;
        this.carView = carView;
    }

    public void start(){
        //경주할 차 이름을 입력 받는다.
        String carsNames = carView.getCarsNames();

        Map<String, String> carNameInfoMap = car.getCarNameInfoMap(carsNames);
        // 경주할 차 이름 입력 값 Map 자료 구조로 받은 뒤 하나씩 차 이름을 검사 한다.
        // 입력 받은 자동차 이름이 입력 조건에 부합하지 않으면 프로그램을 종료한다.
        try {
            checkCarNameValidate(carNameInfoMap);
        } catch (IllegalArgumentException e){
            throw e;
        }

        //시도 횟수를 입력 받는다.
        int numberOfAttempts = carView.getNumberOfAttempts();

        //실행 결과 출력
        System.out.println("실행 결과");
        Map<String, String> stringStringMap = carView.printExecutedResult(car,numberOfAttempts, carNameInfoMap);

        //최종 우승자 리스트
        List<String> winnerList = executedFinalWinnerList(stringStringMap);

        //최종 우승자 출력
        carView.printFinalWinner(winnerList);
    }


    public List<String> executedFinalWinnerList(Map<String, String> stringValueMap){
        List<String> winnerList = new ArrayList<>();
        Map<String, Integer> integerResultValueMap = extractedIntegerValueMap(stringValueMap);

        int maxDistance = getMaxDistance(integerResultValueMap);

        integerResultValueMap.entrySet().stream().filter(entry -> entry.getValue()==maxDistance)
                .forEach(entry -> winnerList.add(entry.getKey()));

        return winnerList;
    }

    private int getMaxDistance(Map<String, Integer> integerMap){
        int maxValue = 0;

        for (Map.Entry<String, Integer> entry : integerMap.entrySet()) {
            int nowValue = entry.getValue();
            if (nowValue > maxValue) {
                maxValue = nowValue;
            }
        }
        return maxValue;
    }


    private Map<String, Integer> extractedIntegerValueMap(Map<String, String> resultMap) {
        final Map<String, Integer> integerResultValueMap = new Hashtable<>();

        for (String carName : resultMap.keySet()) {
            String carDistance = resultMap.get(carName);
            int countDistance = car.countDistance(carDistance);
            integerResultValueMap.put(carName, countDistance);
        }

        return integerResultValueMap;

    }

    private boolean checkCarNameValidate(Map<String, String> maps) {

        for (String carName : maps.keySet()) {
            if (!carValidator.validateCarLength(carName)){
                throw new IllegalArgumentException();
            } else if (!carValidator.validateCarName(carName)){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }


}
