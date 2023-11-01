package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RacingCar {
    Validate validate;
    HashMap<String, String> cars;

    RacingCar(Validate validate) {
        this.validate = validate;
        cars = new HashMap<String, String>();
    }

    public void stratGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = splitCarName(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        Integer round = Integer.parseInt(Console.readLine());
        for(int i = 0; i < round; i++) {
            processRound();
            System.out.println();
        }
        printWinner();
    }

    public HashMap<String, String> splitCarName(String input) {
        HashMap<String, String> newCars = new HashMap<String, String>();
        Arrays.stream(input.split(","))
                .filter(x -> Validate.checkLetterNum(x))
                .forEach(x -> newCars.put(x, ""));
        return newCars;
    }

    public void processRound() {
        cars.forEach((car, state) -> {
            String newState = isAdvance(state);
            cars.put(car, newState);
            System.out.println(String.format("%s : %s", car, newState));
        });
    }

    public String isAdvance(String state) {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            return state+'-';
        }
        return state;
    }

    public void printWinner() {
        List<String> winner = new ArrayList<String>();
        int maxAdvanced = 0;

        for (HashMap.Entry<String, String> entry : cars.entrySet()) {
            String car = entry.getKey();
            int state = entry.getValue().length();
            if (state > maxAdvanced) {
                maxAdvanced = state;
                winner = Arrays.asList(car);
                continue;
            }
            if (state == maxAdvanced) {
                winner.add(car);
                continue;
            }
        }

        System.out.println(String.format("최종 우승자 : %s", String.join(",", winner)));
    }
}
