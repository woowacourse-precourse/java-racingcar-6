package racingcar;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.input.CarTest.Car;
import racingcar.output.MessageTypeTest.MessageType;
import racingcar.output.OutputCarRaceTest.OutputCarRace;

public class CheckMoveAndStopTest {
    private static List<Car> 우승자들 = new ArrayList<>();
    private static int 경주_횟수 = 2;

    public void 차량이름을_입력하라(){
        우승자들.add(Car.inputCarname("pobi1"));
        우승자들.add(Car.inputCarname("pobi2"));
        우승자들.add(Car.inputCarname("pobi3"));
        우승자들.add(Car.inputCarname("pobi4"));
    }

    static class CheckMoveAndStop{
        private int maxDistance = 0;
        private StringBuilder raceResult = new StringBuilder();

        public static CheckMoveAndStop run(List<Car> cars, int raceCount) {
            return new CheckMoveAndStop(cars, raceCount);
        }

        private CheckMoveAndStop(List<Car> cars, int raceCount){
            OutputCarRace.print(MessageType.OUTPUT_RACE_START_PRINT);

            for (int race = 0; race < raceCount; race++) {
                raceCars(cars);
                raceResult.append("\n");
            }

            OutputCarRace.printf(MessageType.OUTPUT_RACE_END_PRINT, raceResult.toString());
        }

        private void raceCars(List<Car> cars) {
            for (Car car : cars) {
                car.moveCar();
                UpdateMaxDistance(car);
                writeRaceResult(car);
            }
        }

        private void UpdateMaxDistance(Car car) {
            StringBuilder driving = car.getDriving();

            if(this.maxDistance < driving.length()){
                this.maxDistance = driving.length();
            }
        }

        private void writeRaceResult(Car car) {
            raceResult.append(format(MessageType.OUTPUT_IMPLEMENTATION_RESULT_PRINT.getValue(),
                    car.getCarName(),
                    car.getDriving()));
        }

        public int getMaxDistance(){
            return this.maxDistance;
        }
    }

    @Test
    void 차량_이동(){
        차량이름을_입력하라();

        CheckMoveAndStop.run(우승자들, 경주_횟수);
    }

}