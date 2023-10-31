package racingcar.domain;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Output {
    public void printCarPosition(HashMap<String,Integer> Racers){
        for(String KEY : Racers.keySet()){
            System.out.printf("%s : ", KEY);
            for(int i=0; i<Racers.get(KEY); i++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printFinalWinner(HashMap<String, Integer> Racers){
        Map<String, Integer> map = new HashMap<>();
        map = Racers;
        List<Map.Entry<String, Integer>> entries;

        entries = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        System.out.print("최종 우승자 : ");

        ListIterator<Map.Entry<String,Integer>> itr = entries.listIterator(entries.size());
        Integer tmp = entries.get(entries.size()-1).getValue();

        while(itr.hasPrevious()){
            if(tmp != itr.previous().getValue()){
                break;
            }
            else{
                itr.next();
                System.out.printf("%s",itr.previous().getKey());
            }
        }
    }
}
