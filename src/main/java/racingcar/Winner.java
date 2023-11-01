package racingcar;

import java.util.ArrayList;
import java.util.List;

/*
   [ ] (12) 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. -> returnWinner()
   [ ] (13) 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. -> returnWinner() in if (winner > 1) */
/* 12 : result의 길이가 max인 우승자를 List<String>.add 한 다음 리턴한다.
 */
/* 13 : (12)에서 넘겨받은 리스트의 크기가 1이면 "{우승자}"를, 2 이상이면 "{우승자}, "를 추가해서 리턴한다.

 */
public class Winner {
    private List<String> winners = new ArrayList<>();
    public List<String> returnWinner(int maxLength, List<String> carResults) {
        for (String s:
             carResults) {
            winners.add(findWinner(maxLength, s));
        }
        return winners;
    }
    public String findWinner(int maxLength, String carResult) {
        if(maxLength == carResult.length()) {
            return carResult;
        }
        return "";
    }
}
