package racer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    
    private HashMap<String, Integer> nameDuplication = new HashMap<String, Integer>(); 
    private int advanceCount;
    private final int advanceCountLimit = 10;           //몇 회 초과시부터 생략 출력할 지
    private final int overLimitDisplayTime = 5;         //생략출력시 앞 뒤로 몇개씩 보여줄 지
    private List<Racer> racers = new ArrayList<Racer>();
    
    public List<Racer> getRacers() {
        return racers;
    }
    
    public void inputNames() {
        String input = Console.readLine();
        setRacers(input);
    }
    
    public void setRacers(String names){
        String[] racerNames = names.split(",");
        for (String name : racerNames) {
            updateNameDuplication(name);
            int duplicationCount = nameDuplication.get(name);
            racers.add(new Racer(name, duplicationCount));
        }
        setDisplayName();
    }
    
    private void updateNameDuplication(String name) {
        if (nameDuplication.containsKey(name)) {
            nameDuplication.put(name, nameDuplication.get(name) + 1);
        } else {
            nameDuplication.put(name, 1);
        }
    }
    
    public void setDisplayName() {
        for (Racer racer : racers) {
            String name = racer.getName();
            int duplicationCount = racer.getDuplicationCount();
            if (nameDuplication.get(name) == 1) {
                racer.setDisplayName(name);
            } else {
                racer.setDisplayName(String.join("", name, "(", String.valueOf(duplicationCount), ")"));
            }
        }
    }
    
    public void inputCount() {
        int advanceCount = Integer.parseInt(Console.readLine());
        setAdvanceCount(advanceCount);
    }
    
    private void setAdvanceCount(int advanceCount) {
        this.advanceCount = advanceCount;
    }
    
    public void startRace() {
        if (advanceCount > advanceCountLimit) {
            doRaceOverLimit();
        }
        if (advanceCount <= advanceCountLimit) {
            doRaceUnderLimit();
        }
        printWinners();
    }
    
    private void doRaceUnderLimit() {
        System.out.println("\n실행결과");
        for (int i = 0; i < advanceCount; i++) {
            updateRacersAdvance();
            printRacers();
        }
    }
    
    private void doRaceOverLimit() {
        System.out.println("\n실행결과");
        int displayAgain = advanceCount - overLimitDisplayTime;
        for (int i = 0; i < advanceCount; i++) {
            updateRacersAdvance();
            if (i < overLimitDisplayTime) {
                printRacers();
            }
            if (i == overLimitDisplayTime) {
                System.out.println("...\n");
            }
            if (i >= displayAgain) {
                printRacers();
            }
        }
    }
    
    private void updateRacersAdvance() {
        for (Racer racer : racers) {
            if (isSuccess()) {
                racer.increaseAdvance();
            }
        }
    }
    
    private boolean isSuccess() {
        int successValue = 4;
        if (Randoms.pickNumberInRange(0, 9) < successValue) {
            return false;
        }
        return true;
    }
 
    private void printRacers() {
        for (Racer racer : racers) {
            printRacer(racer);
        }
        System.out.println();
    }
    
    private void printRacer(Racer racer) {
        System.out.print(String.join(" ", racer.getDisplayName(),":",""));
        for (int i = 0; i < racer.getAdvance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    //Test용 메서드
    public String printRacer_string(Racer racer) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(" ", racer.getDisplayName(),":",""));
        for (int i = 0; i < racer.getAdvance(); i++) {
            sb.append("-");
        }
        sb.append("\n");
        return sb.toString();
    }
    
    public List<Racer> getWinner(){
        List<Racer> winners = new ArrayList<Racer>();
        int maximumAdvance = 0;
        
        for (Racer racer : racers) {
            if (racer.getAdvance() > maximumAdvance) {
                maximumAdvance = racer.getAdvance();
            }
        }
        for (Racer racer : racers) {
            if (racer.getAdvance() == maximumAdvance) {
                winners.add(racer);
            }
        }

        return winners;
    }

    private void printWinners() {
        List<Racer> winners = getWinner();
        List<String> winnerNames = new ArrayList<String>();
        for (Racer racer : winners) {
            winnerNames.add(racer.getDisplayName());
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerNames));
    }
}
