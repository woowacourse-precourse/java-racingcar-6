package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("잘못 입력하셨습니다.");
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        if(count <= 0){
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

    }

}
