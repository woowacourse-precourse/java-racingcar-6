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
}
