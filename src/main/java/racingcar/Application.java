package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    static Racer[] createRacerFromInput() {

        String[] names = Console.readLine().split(",");

        Racer[] racers = new Racer[names.length];

        for(int i=0; i< names.length; i++){
            racers[i] = new Racer(names[i]);
        }

        return racers;
    }

    static int setAttemptCountFromInput(){
        try {
            int attemptCount = Integer.parseInt(Console.readLine());
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수형 입력이 필요합니다.");
        }
    }


    static void attemptOnceWithRacer(Racer racer){
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            racer.increaseProgress();
        }
    }

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        Racer[] racers = createRacerFromInput();

        System.out.println("시도할 회수는 몇회인가요?");

        int attemptCount = setAttemptCountFromInput();

    }
}
