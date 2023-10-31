package racingcar;

import java.util.List;

public class GameResultView {
    public GameResultView() {
    }

    public void gameResultView(List<Integer> UserRace, InputResultModel inputDataList) {
        int dataListSize = inputDataList.getInputDataList().size();
        System.out.print("최종 우승자 : ");
        int max = 0;
        for (int i = 0; i < dataListSize; i++) {
            if (max < UserRace.get(i)) {
                max = UserRace.get(i);
            }
        }
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < dataListSize; i++) {
            if (max == UserRace.get(i)) {
                if (!winners.isEmpty()) {
                    winners.append(", ");
                }
                winners.append(inputDataList.getInputDataList().get(i));
            }
        }
        System.out.println(winners);
    }
}
