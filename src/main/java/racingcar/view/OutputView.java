package racingcar.view;

import java.util.List;

public class OutputView {

    public void printCarNameInputMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRacingCountInputMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRacingResultStartMessage(){
        System.out.println("실행 결과");
    }

    public void printAllCarNowPosition(List<String> carPositionStringList){
        for(String carPositionString : carPositionStringList){
            System.out.println(carPositionString);
        }
        System.out.println();

    }

    public void printWinnerMessage(List<String> winnerList){
        String winners = String.join(",", winnerList);
        System.out.printf("최종 우승자 : %s", winners);
    }


}
