package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        String[] carName = userInput.split(",");

        sizeComparison(carName);
    }

    public static void sizeComparison(String[] carname){ // 차 이름이 5자 이하가 아니면 예외
        for (String s : carname) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}

class Car {

}