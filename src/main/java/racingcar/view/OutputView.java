package racingcar.view;

import java.util.Set;

public class OutputView {

    public void winnerOutView(Set<String> list){
        System.out.println("최종 우승자 : " + String.join(",", list));
    }

    public void carNameOutView(String car){
        System.out.print(car + " : ");
    }

    public void score(){
        System.out.print("-");
    }

    public void newLine(){
        System.out.println();
    }

    public void result(){
        System.out.println("실행 결과");
    }
}
