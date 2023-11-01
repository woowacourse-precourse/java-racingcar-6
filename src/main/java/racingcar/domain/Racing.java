package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {
    public void countMoveRacing(List<String> carNames){
        RandomNumber randomNumber = new RandomNumber();

        System.out.println("시도할 회수는 몇회인가요?");
        int coutMove = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        String[] carStates = new String[carNames.size()];
        Arrays.fill(carStates, "");

        for (int i = 0; i < coutMove; i++) {
            for (int j = 0; j < carNames.size(); j++){
                String carName = carNames.get(j).trim();
                String moveCar = randomNumber.createRandomNumber(carName);
                carStates[j] = addRacingOutput(carStates[j], moveCar);
                racingOutput(carName, carStates[j]);
            }
            System.out.println();
        }

       winNameOutput(carNames, carStates);
    }

    public String addRacingOutput(String carStates, String moveCar){
        if (moveCar.equals("-")) {
            return carStates + "-";
        }
        return carStates;
    }
    public void racingOutput(String carName, String moveCar){
        System.out.println(carName + " : " + moveCar);
    }

    void winNameOutput(List<String> carNames, String[] carStates){
        int max = -1;
        List<String> winningCarNames = new ArrayList<>();

        for (int j = 0; j < carNames.size(); j++){
            int hyphenCount = countHyphens(carStates[j]);
            if (hyphenCount > max) {
                max = hyphenCount;
                winningCarNames.clear();
                winningCarNames.add(carNames.get(j).trim());
            }else if(hyphenCount == max){
                winningCarNames.add(carNames.get(j).trim());
            }
        }

        String winners = String.join(", ", winningCarNames);

        System.out.println("최종 우승자 : " + winners);
    }

    private int countHyphens(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '-') {
                count++;
            }
        }
        return count;
    }
}
