/**
 * @Package_name   : racingCar
 * @Class_name : CarRace
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package racingcar;

import player.*;

import java.util.ArrayList;

public class CarRace {
    /**
     * Description : 자동차 경주 진행 중심 프로세스 코드
     *
     * @Method : carRacing()
     */
    public void carRacing(){
        McPlayer mcPlayer = new McPlayer();
        JudgePlayer judgePlayer = new JudgePlayer();
        ManagePlayer managePlayer = new ManagePlayer(mcPlayer, judgePlayer);

        mcPlayer.play(); // 자동차이름, 시도 횟수를 요청하고, 입력받기
        managePlayer.play(); // mcPlayer와 judgePlayer 사이에서, mcPlayer의 자동차이름들을 받아 각 자동차 이동거리를 알아내 judgePlayer에게 전달
        judgePlayer.play(); // 우승자를 가려내고, 출력함

    }
}
