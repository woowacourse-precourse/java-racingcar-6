package racingcar.domain;

import java.util.List;

public class Announcer {

    public void resultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void result(List resultList, List<String> cars) {

        for (int i = 0 ; i < cars.size() ; i++) {
            System.out.println(cars.get(i)+" : "+resultList.get(i));
        }
        System.out.println();
    }

    public void winner(List winners){
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ",winners));
    }
}
