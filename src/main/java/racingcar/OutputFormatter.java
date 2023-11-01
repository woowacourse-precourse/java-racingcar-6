package racingcar;

import java.util.List;

public class OutputFormatter {

    static void printCurrentStateOfRace(Racer[] racers){
        for(Racer racer : racers) {
            racer.printRacer();
        }
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

}
