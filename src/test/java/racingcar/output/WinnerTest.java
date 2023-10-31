package racingcar.output;

import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;
import racingcar.input.CarTest.Car;
import racingcar.output.MessageTypeTest.MessageType;
import racingcar.output.OutputCarRaceTest.OutputCarRace;

public class WinnerTest extends PrintTest{
    private static List<Car> 우승자들 = new ArrayList<>();
    private static int 우승거리 = 0;

    public void 우승자들_입력(){
        우승자들.add(Car.inputCarname("pobi1"));
        우승자들.add(Car.inputCarname("pobi2"));
    }

    public static class Winner{
        private List<Car> listCar;
        private int maxDistance;

        public static Winner inputWinner(List<Car> listCar, int maxDistance){
            return new Winner(listCar, maxDistance);
        }

        private Winner(List<Car> listCar, int maxDistance){
            this.listCar = listCar;
            this.maxDistance = maxDistance;
        }

        public void printWinner() {
            StringJoiner winnerNames = new StringJoiner(", ");

            setWinners(winnerNames);

            OutputCarRace.printf(MessageType.OUTPUT_WINNERS_PRINT, winnerNames.toString());
        }

        private void setWinners(StringJoiner winnerNames) {
            for (Car car : this.listCar) {
                String carName = car.getCarName();
                StringBuilder driving = car.getDriving();

                if (this.maxDistance == driving.length()) {
                    winnerNames.add(carName);
                }
            }
        }
    }

    @Test
    void 우승자를_출력(){
        우승자들_입력();
        Winner winners = Winner.inputWinner(우승자들, 우승거리);

        winners.printWinner();
    }
}
