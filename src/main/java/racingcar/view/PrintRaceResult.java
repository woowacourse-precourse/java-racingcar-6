package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.global.message.GameProgressMessage;

import java.util.List;

public class PrintRaceResult {

    private static final int FIRST_WINNER = 0;
    private static final int REST_WINNERS = 1;

    private final Race race;

    public PrintRaceResult(Race race){
        this.race = race;
    }

    public void printWinners(List<String> winners){
        GameProgressMessage.PRINT_WINNER.printMessageWithNoNewLine();

        System.out.print(winners.get(FIRST_WINNER));
        for(int i = REST_WINNERS; i < winners.size(); i++){
            System.out.print(", "+ winners.get(i));
        }
    }

    public void printCarsStatus(){
        List<Car> cars = race.getCars();

        for(Car car : cars){
            printCarStatus(car);
        }
        System.out.println();
    }

    public void printCarStatus(Car car){
        System.out.print(car.getCarName() + " : ");

        for(int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
