package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Referee {
    private final static String FINAL_WINNER = "최종 우승자 : ";

    // Distance 를 기준으로 내림차순 정렬하는 기능
    public List<Car> selectWinnerList(List<Car> list) {
        Collections.sort(list, (o1, o2) -> {
            if (o1.getDistance() > o2.getDistance()) {
                return -1;
            }
            if (o1.getDistance() < o2.getDistance()) {
                return 1;
            }
            return o1.getDistance().compareTo(o2.getDistance());
        });
        return list;
    }

    // 우승자 이름을 반환한다.
    public String winnerName(List<Car> list) {
        String name = list.get(0).getName();
        Integer Score = list.get(0).getDistance();

        for (int i = 1; i < list.size(); i++) {
            if (Score.equals(list.get(i).getDistance())) {
                name += ", " + list.get(i).getName();
            }
        }
        return FINAL_WINNER + name;
    }

    // 경기의 랜덤값 이상일 경우 차는 이동 할 수 있다.
    public void startEngine(Car car) {
        if (canStart()) {
            car.accel();
        }
    }

    private boolean canStart() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

}
