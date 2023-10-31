package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    Judgement judgement = new Judgement();
    public void play() {
        List<Car> participants = askParticipants();
        int moveCnt = askMoveCnt();
        System.out.println("실행 결과");
        while (moveCnt > 0) {
            for (Car participant : participants) {
                participant.move();
            }
            System.out.println();
            moveCnt--;
        }
        List<String> winners = judgement.selectWinners(participants);
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    public List<Car> askParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String names = Console.readLine().replaceAll(" ", "");
        List<Car> participants = new ArrayList<>();
        List<String> carNames = Arrays.asList(names.split(","));
        for (String carName : carNames) {
            participants.add(new Car(carName));
        }
        return participants;
    }

    public int askMoveCnt() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }


}
