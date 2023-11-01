package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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

    static void attemptAllRacer(Racer[] racers) {
        for(Racer racer : racers){
            attemptOnceWithRacer(racer);
        }
    }

    static void attemptOnceWithRacer(Racer racer){
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            racer.increaseProgress();
        }
    }

    static void printCurrentStateOfRace(Racer[] racers){
        for(Racer racer : racers) {
            racer.printRacer();
        }
    }

    static List<Racer> findWinner(Racer[] racers){
        List<Racer> winners = new ArrayList<>();
        int maxProgress = 0;

        for (Racer racer : racers) {
            int progress = racer.getProgress();
            if (progress > maxProgress) {
                maxProgress = progress;
            }
        }

        for (Racer racer : racers) {
            if (racer.getProgress() == maxProgress) {
                winners.add(racer);
            }
        }

        return winners;
    }

    static void printNamesOfRacers(List<Racer> racers){
        int len = racers.size();
        for (int i=0; i<len; i++){
            if(i!=0){
                System.out.print(", ");
            }
            System.out.print(racers.get(i).getName());
        }
    }

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Racer[] racers = createRacerFromInput();

        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = setAttemptCountFromInput();

        System.out.println("실행 결과");
        for(int i=0; i<attemptCount; i++){
            attemptAllRacer(racers);
            printCurrentStateOfRace(racers);
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        printNamesOfRacers(findWinner(racers));

    }
}
