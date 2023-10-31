package racingcar.view;

import racingcar.controller.Controller;

import java.util.List;

public class OutputView {
    public void printAskName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult(){
        System.out.println("\n실행 결과");
    }

    public void printInterm(String intermprint){
        System.out.println(intermprint);
    }

    public void printWinner(List<String> winners){
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : "+result);

    }
}
