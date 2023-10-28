package racingcar.model;

public class RacingGame {

    private final Cars cars;
    private final int tryCount;

    private static final String NEW_LINE = "\n";

    public RacingGame(Cars cars, int tryCount){
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public String makeStatus(){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<tryCount; i++){
            cars.forward();
            result.append(cars.toString());
            result.append(NEW_LINE);
        }
        return result.toString();
    }

    public void judgeFinalWinner(){
        // TODO 최종 우승자
    }










}
