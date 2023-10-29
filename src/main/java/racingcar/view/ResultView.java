package racingcar.view;

import racingcar.domain.Player;

import java.util.List;

public class ResultView {

    public void winView(List<Player> winners){
        System.out.println("최종 우승자 : ");

            for (int i = 0; i < winners.size() - 1; i++) {
                System.out.print(winners.get(i).getName() + ", ");
            }

        System.out.println(winners.get(winners.size()-1).getName());
    }
}
