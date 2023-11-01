package racingcar;

import java.util.List;

public class PlayGame {

    private Logic logic;
    private int tryTimes;

    public PlayGame() {
        UserInputView userInputView = new UserInputView();
        this.logic = new Logic(userInputView.getCarNames());
        this.tryTimes = userInputView.getTryTimes();
    }

    public void startGame() {
        System.out.println("\n# 라운드 별 경기 결과 # \n");

        for(int i = 0; i < tryTimes; i++) {
            System.out.println("<Round " + (i + 1) + ">");
            logic.performEachRound();
            System.out.println();
        }
        List<String> winners = logic.findWinners();
        listOfWinner(winners);
    }

    private void listOfWinner(List<String> winners) {
        String winnerMembers = String.join(",", winners);
        System.out.println("최종 우승자 : " + winnerMembers);
    }

}