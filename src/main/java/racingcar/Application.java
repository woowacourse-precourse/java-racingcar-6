package racingcar;

public class Application {
    public static void main(String[] args) {
        RaceCarsInput raceCarsInput = new RaceCarsInput();
        Record record = new Record();

        record.setCars(raceCarsInput.getNames());
        int times = raceCarsInput.getTimes();

        System.out.println("\n실행 결과");
        for (int i = 0; i < times; i++) {
            record.runCars();
            record.getRecord();
        }

        record.getWinner();
    };
}
