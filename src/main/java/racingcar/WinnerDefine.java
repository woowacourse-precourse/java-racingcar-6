package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerDefine {

    static final String WINNER_SENTENCE = "최종 우승자 : ";
    public WinnerDefine() {
    }

    public static void DefineWinner(List<String> nameList, List<String> distance) {
        int disLen = 0;
        List<Integer> index = new ArrayList<>();
        int winnerIndex = 0;

        for(int i = 0; i < nameList.size(); i++) {
            if(distance.get(i).length() > disLen) {
                winnerIndex = i;
                disLen = distance.get(i).length();
            }
        }

        for(int i = 0; i < nameList.size(); i++) {
            if(distance.get(winnerIndex).length() == distance.get(i).length()) {
               index.add(i);
            }
        }

        System.out.print(WINNER_SENTENCE);
        for(int i = 0; i < index.size(); i++) {
            if(i == (index.size()-1)) {
                System.out.println(nameList.get(index.get(i)));
            }
            else {
                System.out.print(nameList.get(index.get(i)) + ", ");
            }
        }

    }
}
