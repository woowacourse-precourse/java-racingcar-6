package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class RacingCarController {
    private RacingCar racingCar;
    private RacingCarInput racingCarInput;
    private ValidInputChecker validInputChecker;

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    private final Map<String, String> stringResultValueMap = new HashMap<>();

    public RacingCarController(RacingCar racingCar, RacingCarInput racingCarInput, ValidInputChecker validInputChecker){
        this.racingCar = racingCar;
        this.racingCarInput = racingCarInput;
        this.validInputChecker = validInputChecker;
    }

    public void startRacing(){
        String carNames = racingCarInput.getCarNames();

        Map<String, String> carNameHashMap = racingCar.getCarName(carNames);
        checkCarNameValidate(carNameHashMap);

        int tryCnt = racingCarInput.getTryCount();

        System.out.println(RESULT_MESSAGE);
        Map<String, String> stringMap = printResult(tryCnt, carNameHashMap);

        List<String> winners = makeWinnerList(stringMap);
        printWinners(winners);

    }

    private Map<String, String> makeResult(Map<String, String> carNameHashMap){
        for(String carName : carNameHashMap.keySet()){
            String distance = carNameHashMap.get(carName);
            if(racingCar.carMoveForward()){
                distance += "-";
                stringResultValueMap.put(carName,distance);
            }
            System.out.println(carName + " : " + distance);
        }
        return stringResultValueMap;
    }

    private Map<String, String> printResult(int tryCnt, Map<String, String> carNameHashMap){
        for(int cnt=0; cnt<tryCnt; cnt++) {
            makeResult(carNameHashMap);
            System.out.println();
        }

        return stringResultValueMap;
    }

    public int getMaxDistance(Map<String, Integer> integerValueMap){
        int maxValue = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry : integerValueMap.entrySet()){
            int nowValue = entry.getValue();
            if(nowValue > maxValue){
                maxValue = nowValue;
            }
        }
        return maxValue;
    }

    public Map<String, Integer> makeIntegerValueMap(Map<String, String> resultMap){
        final Map<String, Integer> integerResultValueMap = new HashMap<>();

        for(String carName : resultMap.keySet()){
            String carDistance = resultMap.get(carName);
            int countDistacnce = racingCar.countDistance(carDistance);
            integerResultValueMap.put(carName, countDistacnce);
        }

        return integerResultValueMap;
    }

    public List<String> makeWinnerList(Map<String, String> stringMap){
        List<String> winnerList = new ArrayList<>();
        Map<String, Integer> integerValueMap = makeIntegerValueMap(stringMap);

        int maxDistance = getMaxDistance(integerValueMap);

        integerValueMap.entrySet().stream().filter(entry -> entry.getValue()==maxDistance )
                .forEach(entry -> winnerList.add(entry.getKey()));

        return winnerList;
    }

    private void printWinners(List<String> winnerList){
        System.out.println(WINNER_MESSAGE + String.join(", ",winnerList));
    }

    private void checkCarNameValidate(Map<String, String> hashMap) {
        for (String carName : hashMap.keySet()) {
            validInputChecker.checkCarNameIsEmpty(carName);
            validInputChecker.checkCarNameLength(carName);
        }
    }


}

