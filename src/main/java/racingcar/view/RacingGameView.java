package racingcar.view;

import java.util.List;

public class RacingGameView {

    // 4. 자동차 이름을 입력해달라는 문구를 출력하는 기능
    public void showCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

//    3. 최종 우승자(들)을 출력하는 기능
    public void printFinalWinners(List<String> winnerList) {
        String winners = "최종 우승자 : ";
        winners += String.join(", ", winnerList);
        System.out.print(winners);
    }
}
