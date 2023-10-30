package racingcar.view;

import java.util.List;

public class OutputView {
    public void askNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printInterm(String intermprint){
        System.out.println(intermprint);
    }

    public void printWinner(List<String> winners){
        // 결과 리턴
    }

    public void printError(){
        System.out.println("잘못된 값을 입력하셨습니다. 프로그램이 종료됩니다.");
    }
}
