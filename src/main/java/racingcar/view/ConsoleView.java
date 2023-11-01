package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Vehicle;

import java.util.List;

public class ConsoleView implements View {
    private void out(String data) {
        System.out.println(data);
    }

    @Override
    public String getPlayerInfo() {
        out("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String getRoundInfo() {
        out("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    @Override
    public void printRoundProgress(List<Vehicle> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            Vehicle player = playerList.get(i);
            String winStatus = drawScore(player.getScore());
            out(player.getName() + " : " + winStatus);
        }
        out("");
    }

    private String drawScore(int winCount) {
        StringBuilder winStatus = new StringBuilder();
        for (int i = 0; i < winCount; i++) {
            winStatus.append('-');
        }
        return winStatus.toString();
    }

    @Override
    public void printWinner(List<String> winnerList) {
        StringBuilder winner = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            winner.append(winnerList.get(i));
            if (i == winnerList.size() - 1) {
                break;
            }
            winner.append(", ");
        }
        out(winner.toString());
    }
}
