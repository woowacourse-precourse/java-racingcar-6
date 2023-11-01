package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static class car {
        String name;
        int step;

        car(String name) {
            this.name = name;
            this.step = 0;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputs = Console.readLine().split(",");
        List<car> cars = new ArrayList<>();
        for(int i=0; i<inputs.length; i++) {
            if(inputs[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new car(inputs[i]));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int number = Integer.parseInt(Console.readLine());
    }

    public static int goStep(int step) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if(randomNumber < 4) {
            return step;
        } else {
            return step + randomNumber;
        }
    }

    public static String printStep(int step) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<step; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
