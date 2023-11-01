package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class CarRace {

    private Map<String, Integer> carList;
    private int round;

    public void start(){
        initCarsName();
        initRound();
        for(int i = 0; i < round; i++){
            playRound();
        }
        findWinner();
    }

    private void initCarsName(){
        carList = new HashMap<>();
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNamesWithComma = Console.readLine();
        String carNamesWithCommaReplacedSpace = carNamesWithComma.replaceAll(" ", "");
        Arrays.stream(carNamesWithCommaReplacedSpace.split(",")).forEach(carName -> {
                    if(carName.length() > 5 || carName.length() < 1){
                        throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
                    }else{
                        carList.put(carName, 0);
                    }
                }
        );
    }

    private void initRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInputs = Console.readLine();
        validateUserInput(userInputs);
        round = Integer.valueOf(userInputs);
    }

    private void playRound() {
        carList.forEach((carName, carPosition) -> {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if(randomValue >= 4){
                carList.put(carName, carPosition + 1);
            }
        });
        printRoundResult();
    }

    private void findWinner() {
        int maxPosition = carList.values().stream().max(Integer::compareTo).get();
        List<String> winners = new ArrayList<>();
        System.out.print("최종 우승자 : ");
        carList.forEach((carName, carPosition) -> {
            if(carPosition == maxPosition){
                winners.add(carName);
            }
        });
        if(winners.size() > 1){
            System.out.println(String.join(", ", winners));
        }else {
            System.out.println(winners.get(0));
        }
    }

    private void printRoundResult() {
        carList.forEach((carName, carPosition) -> {
            System.out.print(carName + " : ");
            for(int i = 0; i < carPosition; i++){
                System.out.print("-");
            }
            System.out.println();
        });
    }

    private void validateUserInput(String userInputs) {
        if(!userInputs.matches("[0-9]+")){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

}
