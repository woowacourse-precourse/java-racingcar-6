package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        List<String> carList = new ArrayList<>(Arrays.asList(carsInput.split(",")));

        for (String car: carList){
            if (car.length() > 5) throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해주세요.");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String countInput = Console.readLine();
        try{
            int count = Integer.parseInt(countInput);
            if(count == 0) throw new IllegalArgumentException("0 이외의 숫자를 입력해주세요");

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
