package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int racingCount;

    public Racing(int racingCount) {
        this.racingCount = racingCount;
    }

    public void Race(List<Racer> racers){ //racingCount만큼 race를진행
        for(int i = 0; i < this.racingCount; i++){
            for (Racer racer : racers) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) { //각 racer마다 각각의 random점수를 출력 후 ,4이상일 경우 1점승점 추가
                    racer.advance();
                }
            }
            for (Racer racer : racers) {
                System.out.println(racer); //racer별로 점수 출력
            }
            System.out.println(); //한줄 띄기
        }

        printWinners(racers); //count횟수만큼 진행 후 승자 출력
    }

    private void printWinners(List<Racer> racers) { //승자 출력 함수
        int maxPosition = getMaxPosition(racers); //racer별로 최대점수를 구함
        List<String> winners = new ArrayList<>();

        for (Racer racer : racers) { //최대 Position에 도달할 경우 승자에 추가(둘이상 승자가 나올경우)
            if (racer.position.length() == maxPosition) {
                winners.add(racer.name);
            }
        }

        System.out.println("최종 우승자 : "+String.join(", ", winners)); //승자 출력(둘 이상일 경우 ,를 통해 출력)
    }

    private int getMaxPosition(List<Racer> racers) { //최대 Position선별
        int max = -1;
        for (Racer racer : racers) { //모든 레이서별로 max값을 추출
            max = Math.max(max, racer.position.length());
        }
        return max;
    }
}