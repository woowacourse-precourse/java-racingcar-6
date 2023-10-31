package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차 이름 쉼표로 구분하여 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strName = Console.readLine();
        String[] sepStr = strName.split(",");
        List<String> carName = new ArrayList<>();

        // 이름이 6자 이상인 경우 예외 발생
        for (int i = 0; i < sepStr.length; i++) {
            if (sepStr[i].length() <= 5) {
                carName.add(sepStr[i]);
            } else {
                throw new IllegalArgumentException("5자 이하로 입력하세요.");
            }
        }

        // 이동할 횟수 입력받기
        System.out.println("시도할 횟수는 몇회인가요?");
        String strNum = Console.readLine();
        System.out.println();
        System.out.println("실행 결과");

        // 이동할 횟수가 숫자가 아닌 경우 예외 발생
        for (int i = 0; i < strNum.length(); i++) {
            if (!Character.isDigit(strNum.charAt(i))) {
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }
        }
        int moveNum = Integer.parseInt(strNum);



    }
}
