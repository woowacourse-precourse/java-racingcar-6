package racingcar.v4;
import camp.nextstep.edu.missionutils.Console;
public class CreateCar {
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if(input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열이 아닌 값을 입력해주세요.");
        }
        return input;
    }

}
