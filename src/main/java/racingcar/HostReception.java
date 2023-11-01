package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class HostReception {
    List<RacingCar> participants = new ArrayList<>();

    public TreeSet<RacingCar> getParticipant () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String participants = Console.readLine();
        List<String>  participant= Arrays.stream(participants.split(",")).toList();

        participant.forEach(this::checkValidCarName);

        return createRacingCarSetFromParticipantList(participant);
    }

    private TreeSet<RacingCar> createRacingCarSetFromParticipantList (List<String> names) {
        TreeSet<RacingCar> participants = new TreeSet<>();

        for (String name : names) {
            RacingCar applicant = new RacingCar(name);

            this.participants.add(applicant);
            participants.add(applicant);
        }

        return participants;
    }

    public int getRoundFromUser () {
        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();

        if (!round.matches("^-?\\d+$")) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
        System.out.println();
        return Integer.parseInt(round);
    }

    private boolean checkValidCarName (String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        return true;
    }

    public void proceedARound () {
        participants.forEach(e -> {
            confirmProceed(e);
            printProceedStatus(e);
        });
    }

    private void confirmProceed (RacingCar car) {
        int num = Randoms.pickNumberInRange(0,9);

        if (num >= 4) {
            car.goForward();
        }
    }

    private void printProceedStatus (RacingCar car) {
        System.out.print(car + " : ");
        System.out.println(car.showCarsStatus());
    }

}
