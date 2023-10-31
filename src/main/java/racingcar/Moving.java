package racingcar;

import java.util.List;

public class Moving {

    private User user = new User();
    private Winner winner = new Winner();
    private Moving moving = new Moving();

    private List<String> carNames;
    private int trialNumber;



    public void play() {
        user.setCarName();
        user.setTrialNumber();

        for (int i = 0; i < trialNumber; i++) {
            // 시도할 횟수만큼 이름과 이동거리를 출력해주는 메서드를 실행한다.
        }


    }

}
