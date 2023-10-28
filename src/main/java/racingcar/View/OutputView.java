package racingcar.View;

import java.util.List;

public class OutputView {

    public void finishGame(List<String> members) {
        System.out.println("최종 우승자 : ");
        for(int i = 0; i<members.size(); i++) {
            System.out.print(members.get(i));
            if(i != members.size() - 1) System.out.print(",");
        }
    }
}
