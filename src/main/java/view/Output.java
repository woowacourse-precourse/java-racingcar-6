package view;

import java.util.List;
import model.domain.Car;
import model.domain.Name;
import model.domain.Participant;

public class Output {

    public static void startResult() {

        System.out.println("\n실행 결과");

    }

    public static void roundResult(Participant participant) {

        for (Car car : participant.getParticipant()) {

            Name name = car.getName();
            System.out.print(name.getName() + " : ");

            for (int i = 0; i < car.getGo(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void finalResult(List<Name> winner) {

        System.out.print("최종 우승자 : ");

        for(int i = 0; i < winner.size(); i++){

            Name name = winner.get(i);
            System.out.print(name.getName());

            if(i != (winner.size() - 1)){
                System.out.print(", ");
            }
        }

    }

}
