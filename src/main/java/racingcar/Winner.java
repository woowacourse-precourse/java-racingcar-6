package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Winner {
    public List<String> winners=new ArrayList<>();

    public Winner(Map<String,Integer>CarAndAdvance){
        findWinner(CarAndAdvance);
    }
    public void findWinner(Map<String,Integer>CarAndAdvance){
        List<String> winners=new ArrayList<>();
        for (String key : CarAndAdvance.keySet()) {
            if (winners.isEmpty()) {
                winners.add(key);
            } else {
                turnaroundOrTie(CarAndAdvance,winners,key);
            }
        }
        this.winners=winners;
    }
    private void turnaroundOrTie(Map<String,Integer>CarAndAdvance,List<String> originalWinner,String key){
        int originalWinnersAdvance = CarAndAdvance.get(originalWinner.get(0));
        if (CarAndAdvance.get(key) > originalWinnersAdvance) {
            tieAct(originalWinner,key);
        } else if (CarAndAdvance.get(key) == originalWinnersAdvance) {
            turnaroundAct(originalWinner,key);
        }
    }
    private void tieAct(List<String> originalWinner,String winner){
        originalWinner.clear();
        originalWinner.add(winner);
    }
    private void turnaroundAct(List<String> originalWinner,String winner){
        originalWinner.add(winner);
    }
    public void printWinner(){
        System.out.print("\n최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            if (i != winners.size() - 1) System.out.print(winners.get(i) + ", ");
            else System.out.println(winners.get(i));
        }
    }
}
