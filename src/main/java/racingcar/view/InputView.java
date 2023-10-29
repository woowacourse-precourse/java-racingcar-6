package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carArray = input.split(",");

        List<String> cars = new ArrayList<>();

        for (String car : carArray) {
            if (car.length()>5) {
                throw new IllegalArgumentException("자동차 이름 5글자 초과");
            }
            cars.add(car.trim());   // 앞 뒤 공백 제거
        }
        return cars;
    }

    public int getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int count = -1;
        try {
            count = Integer.parseInt(input);
            if (count <= 0) {   // 음수 값을 입력했을 때
                throw new IllegalArgumentException("음수 값은 허용되지 않습니다.");
            }
        } catch (IllegalArgumentException e) {  // 정수가 아닌 값을 입력했을 때
            System.out.println("올바른 정수 값을 입력해주세요.");
        }
        return count;
    }
}
