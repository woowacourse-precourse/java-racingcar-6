package view;

import java.util.List;
import model.domain.Car;
import model.domain.Go;
import model.domain.Name;
import model.domain.Participant;
import model.domain.Winner;

public class Output {

    public static void startResult() {

        System.out.println("\n실행 결과");

    }

    public static void roundResult(Participant participant) {

        for (Car car : participant.getParticipant()) {

            String name = car.getNameValue();
            System.out.print(name + " : ");

            int goValue = car.getGoValue();
            for (int i = 0; i < goValue; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void finalResult(Winner winner) {

        System.out.print("최종 우승자 : ");

        List<Name> names = winner.getWinner();
        for(int i = 0; i < names.size(); i++){

            Name name = names.get(i);
            System.out.print(name.getName());

            if(i != (names.size() - 1)){
                System.out.print(", ");
            }
        }

    }

}
