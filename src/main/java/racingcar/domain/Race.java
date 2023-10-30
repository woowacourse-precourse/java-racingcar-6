package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    /**
     * 여러 우승자들을 쉼표로 묶어서 프린트하는 함수
     */
    public void printWinner(List<String> names, List<Integer> movementList, int moveCount) {
        List<String> winnerList = extractWinner(names, movementList, moveCount);
        String winners = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winners);
    }

    // 우승자가 여러명일때 추출하기
    public List<String> extractWinner(List<String> names, List<Integer> movementList, int moveCount) {
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if (movementList.get(i).equals(moveCount)) {
                winnerList.add(names.get(i));
            }
        }
        return winnerList;
    }
}
