package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static Object[] getUserInput(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String user_input = Console.readLine();

        System.out.println("시도할 회수는 몇회 인가요?");
        int try_cnt = Integer.parseInt(Console.readLine());

        return new Object[]{user_input, try_cnt};
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Object[] user_input = getUserInput();

        Randoms.pickNumberInRange(0,9);
    }
}
