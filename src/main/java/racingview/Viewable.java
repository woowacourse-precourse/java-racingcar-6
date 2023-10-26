package racingview;

import java.util.LinkedHashMap;
import java.util.List;

public interface Viewable {
    void speakStart();

    void askForTimes();

    void speakResultStart();

    void speakResult(LinkedHashMap<String, StringBuilder> map);

    default void speakWinner(List<String> winner) {
        System.out.printf("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {

            System.out.printf("%s",winner.get(i));
            if (i != winner.size() - 1) {
                System.out.printf(", ");
            }
        }
    }
}
