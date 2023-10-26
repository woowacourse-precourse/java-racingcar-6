package racingview;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainView implements Viewable {
    @Override
    public void speakStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void askForTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void speakResultStart() {
        System.out.printf("\n실행 결과\n");
    }

    @Override
    public void speakResult(LinkedHashMap<String, StringBuilder> map) {
        for (Map.Entry<String, StringBuilder> entry : map.entrySet()) {
          System.out.printf("%s : %s\n",entry.getKey(),entry.getValue().toString());
        }
        System.out.println();
    }
}
