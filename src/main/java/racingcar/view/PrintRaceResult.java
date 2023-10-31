package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.global.message.GameProgressMessage;

import javax.xml.transform.sax.SAXSource;
import java.util.List;

public class PrintRaceResult {

    private static final int FIRST_WINNER = 0;
    private static final int REST_WINNERS = 1;

    private final Race race;
    private StringBuffer stringBuffer;

    public PrintRaceResult(Race race){
        this.race = race;
    }

    public String printWinners(List<String> winners){
        stringBuffer = new StringBuffer();
        GameProgressMessage.PRINT_WINNER.printMessageWithNoNewLine();

        stringBuffer.append(winners.get(FIRST_WINNER));
        for(int i = REST_WINNERS; i < winners.size(); i++){
            stringBuffer.append(", ").append(winners.get(i));
        }
        String result = stringBuffer.toString();
        System.out.println(result);
        return result;
    }

    public String printCarsStatus(){
        stringBuffer = new StringBuffer();
        List<Car> cars = race.getCars();

        for(Car car : cars){
            stringBuffer.append(printCarStatus(car));
        }
        stringBuffer.append("\n");
        String result = stringBuffer.toString();
        System.out.println(result);
        return result;
    }

    public String printCarStatus(Car car){
        stringBuffer = new StringBuffer();
        stringBuffer.append(car.getCarName()).append(" : ");

        for(int i = 0; i < car.getLocation(); i++) {
            stringBuffer.append("-");
        }
        stringBuffer.append("\n");
        String result = stringBuffer.toString();
        System.out.println(result);
        return result;
    }
}
