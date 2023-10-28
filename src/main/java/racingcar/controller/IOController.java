package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Cars;

public class IOController {

    public static List<String> showStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        //validate
        String[] given = input.split(",");
        List<String> names = new ArrayList<>();
        for(String item : given) {
            if(item.length() > 5) {throw new IllegalArgumentException("nameError");}
            names.add(item);
        }
        return names ;
    }

    public static void showResultIntro() {
        System.out.println("실행 결과");
    }

    public static void showWinnerName(List<String> names) {
        System.out.println("최종 우승자 : "+names.toString().replace("]","").replace("[",""));
    }

    public static int showEpochMessage() {
        System.out.println("시도할 회수는 몇회인가요?\n");
        return Integer.parseInt(Console.readLine());
    }

    public static void showRoundResult(Cars cars) {
        for(int i =0 ; i < cars.getSize();i++) {
            System.out.println(cars.getResult(i));
        }
    }

}
