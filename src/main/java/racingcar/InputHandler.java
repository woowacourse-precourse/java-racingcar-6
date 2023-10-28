package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String[] carNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] carNames = input.split(",");

        for (String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("이름은 5자리 이하만 가능합니다.");
            }
        }

        return carNames;
    }

    public static Integer tryNumberInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Integer.parseInt(Console.readLine());

        return input;

    }
}
