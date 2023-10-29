package racingcar;

public class Game {

    private Cars cars = new Cars();
    private Integer roundCount;

    public void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Input.getCarNames();
        cars.set(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        setRoundCount(Input.getRoundCount());
        System.out.println();
        System.out.println("실행 결과");
        startRound();

        Winner winner = new Winner(cars.getWinners());
        winner.printWinner();
    }

    public void startRound(){
        for(int i=0; i<roundCount; i++){
            cars.moveAll();
            cars.printCarPositions();
        }
    }

    public void setRoundCount(Integer roundCount){
        this.roundCount = roundCount;
    }

    public Integer getRoundCount(){
        return roundCount;
    }
}
