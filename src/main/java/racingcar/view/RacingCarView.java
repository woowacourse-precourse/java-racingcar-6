package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class RacingCarView {
    public String getCarsNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        System.out.println(inputCarNames);

        return inputCarNames;
    }

    public int getNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        System.out.println(numberOfAttempts);

        return numberOfAttempts;
    }

    public void printFinalWinner(List<String> winnerList){
        System.out.println("최종 우승자 : " + String.join(", ",winnerList));
    }

    public Map<String, String> printExecutedResult(Car car, int numberOfAttempts, Map<String, String> carNameInfoMap) {

        final Map<String, String> stringResultValueMap = new Hashtable<>();

        for (int index = 0; index < numberOfAttempts; index++){
            for (String carName : carNameInfoMap.keySet()) {
                String distance = carNameInfoMap.get(carName);
                if(car.isCarMovingForward()){
                    distance += "-";
                    stringResultValueMap.put(carName, distance);
                }
                System.out.println(carName +" : " + distance);
            }
            System.out.println();
        }

        return stringResultValueMap;
    }
}
