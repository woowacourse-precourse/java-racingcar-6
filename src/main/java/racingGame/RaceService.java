package racingGame;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    // 랜덤변수를 통해 간 거리 계산
    public void goForward(RaceVO racer) {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            racer.upGoalCnt();
        }
    }

    // 레이서들 간 길이 출력
    public void printRacer(RaceVO racer) {
        System.out.print(racer.getCarName() + " : ");
        for(int i=0; i<racer.getGoalCnt(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    // 우승자 체크
    public List<String> checkWinner(List<RaceVO> carNames) {
        int max = 1;

        // 최대 거리만큼 간 거리 계산
        for(RaceVO racer: carNames) {
            if(racer.getGoalCnt() > max) {
                max = racer.getGoalCnt();
            }
        }

        // 계산한 거리만큼 간 레이서(우승자) 배열에 추가
        List<String> winners = new ArrayList<>();
        for(RaceVO racer: carNames) {
            if(racer.getGoalCnt() == max) {
                winners.add(racer.getCarName());
            }
        }

        return winners;
    }

    // 우승자 출력 함수
    public void showWinners(List<String> winners) {
        // 단독 우승일 경우
        if(winners.size() == 1) {
            System.out.println(winners.get(0));
            return;
        }

        // 공동 우승일 경우
        for(int i=0; i<winners.size(); ++i) {
            System.out.print(winners.get(i));
            if(i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
