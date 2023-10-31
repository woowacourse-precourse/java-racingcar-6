package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Racing {
    public void countMoveRacing(List<String> carNames){
        RandomNumber randomNumber = new RandomNumber();

        System.out.println("시도할 회수는 몇회인가요?");
        int coutMove = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        String[] carStates = new String[carNames.size()];
        Arrays.fill(carStates, "");

        for (int i = 0; i < coutMove; i++) {
            for (int j = 0; j < carNames.size(); j++){
                String carName = carNames.get(j).trim();
                String moveCar = randomNumber.createRandomNumber(carName);
                carStates[j] = addRacingOutput(carStates[j], moveCar);
                racingOutput(carName, carStates[j], i);
            }
            System.out.println();
        }
    }

    public String addRacingOutput(String carStates, String moveCar){
        if (moveCar.equals("-")) {
            return carStates + "-";
        }
        return carStates;
    }
    public void racingOutput(String carName, String moveCar, int index){
        System.out.println(carName + " : " + moveCar);
    }

    public String windNameOutput(String carName){
        return null;
    }
}
