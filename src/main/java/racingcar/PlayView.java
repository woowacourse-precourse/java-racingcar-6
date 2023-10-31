package racingcar;

import java.util.List;

public class PlayView {
    public PlayView() {
    }

    public void PlayResultView(List<Integer> UserRace, InputResultModel inputDataList, int now) {
        if (now == 0)
            System.out.println("실행 결과");
        int dataListSize = inputDataList.getInputDataList().size();
        int numberOfTime = inputDataList.getNumberOfTime();
        for (int i = 0; i < dataListSize; i++) {
            System.out.print(inputDataList.getInputDataList().get(i) + " : ");
            for (int j = 0; j < UserRace.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        if (numberOfTime - 1 == now) {
            GameResultView gameResultView = new GameResultView();
            gameResultView.gameResultView(UserRace, inputDataList);
        }
    }
}
