package racingcar;

import racingcar.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomNumber();
        System.out.println(computer);

        List<String> car = askName();
        int num = tryNum();

        System.out.println(car);
        System.out.println(num);
    }

    public static List<String> askName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();

        List<String> carNames = new ArrayList<>();
        for(String name : input.split(",")){
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름이 5자가 넘습니다.");
            }
            carNames.add(name);
        }
        return carNames;
    }

    public static int tryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Integer.parseInt(readLine());

        return input;
    }
}
