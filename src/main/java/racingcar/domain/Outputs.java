package racingcar.domain;

import java.util.List;

public class Outputs {

    public static void resultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void result(List resultList) {
        List<String> cars = InputDesk.getCars();
        for (int i = 0 ; i < cars.size() ; i++) {
            System.out.println(cars.get(i)+" : "+resultList.get(i));
        }
        System.out.println();
    }

    public static void winner(List winners){
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ",winners));
    }
}
