package racingcar;

import static java.lang.String.format;

import java.util.List;
import racingcar.input.Car;
import racingcar.output.MessageType;
import racingcar.output.OutputCarRace;

public class CheckMoveAndStop {
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
