package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private List<Car> cars;
    private Integer turn;
    private Judge judge;

    public RacingGame(int maxNameLength, int forwardCriterion, int lowerBoundRandomNumber, int upperBoundRandomNumber) {
        cars = new ArrayList<>();
        turn = 0;
        judge = new Judge(maxNameLength, forwardCriterion, lowerBoundRandomNumber, upperBoundRandomNumber);
    }

    /**
     * 한 게임의 순서 관리
     */
    public void play(){
        this.cars = setCars();
        this.turn = setTurn();
        System.out.println();
        iterRun();
        finish();
    }

    /**
     * 사용자에게 자동차를 입력받아 구분자를 통해 자동차 리스트 반환
     * @return 자동차 리스트
     */
    private List<Car> setCars() {
        printQuestionAskingNames();
        Optional<String> input = askCarNames();
        judge.isEffectiveInputNames(input);
        return makeCars(input);
    }

    void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 시작 문구 출력
     */
    private void printQuestionAskingNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    /**
     * 사용자에게 자동차 리스트 입력 요청
     * @return 입력받은 값의 Optional씌운 값
     */
    private Optional<String> askCarNames() {
        return Optional.ofNullable(Console.readLine());
    }

    /**
     * 사용자의 입력값을 통해 자동차 리스트 생성
     * @param input 사용자 입력의 Optional
     * @return 구분자로 구분된 자동차 리스트
     */
    List<Car> makeCars(Optional<String> input) {
        List<String> inputs = Arrays.stream(input.get().split(",")).toList();

        List<Car> cars = new ArrayList<>();
        inputs.forEach(str -> cars.add(new Car(str)));
        return cars;
    }

    /**
     * 사용자에게 시도횟수를 입력받아 필드값 지정
     * @return 사용자가 입력한 값의 Integer
     */
    private Integer setTurn() {
        printQuestionAskingTurn();
        Optional<String> inputTurn = askTurn();
        judge.isEffectiveInputTurn(inputTurn);
        return convertTypeToInteger(inputTurn);
    }

    void setTurn(Integer turn){
        this.turn = turn;
    }

    /**
     * 시도 횟수 요청 문구
     */
    private void printQuestionAskingTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    /**
     * 사용자의 시도횟수 입력 요청
     * @return 사용자의 시도횟수 입력의 Optional
     */
    private Optional<String> askTurn() {
        return Optional.ofNullable(Console.readLine());
    }

    /**
     * 사용자의 입력을 Integer로 변환
     * @param inputTurn 사용자의 입력
     * @return 정상적인 입력의 Integer 형태
     */
    private Integer convertTypeToInteger(Optional<String> inputTurn) {
        return Integer.parseInt(inputTurn.get());
    }

    /**
     * 각 실행의 결과 출력
     */
    private void iterRun(){
        System.out.println("실행 결과");

        for(int i=0; i<turn; i++) {
            playOneTurn();
            printCarsStatus();
            System.out.println();
        }
    }

    /**
     * 한 턴마다 각 자동차의 동작 수행
     */
    private void playOneTurn() {
        cars.forEach(car -> {
            if(judge.canMove(judge.pickRandomNumber())){
                car.incrementForwardCount();
            }
        });
    }

    /**
     * 자동차의 상태 출력
     */
    void printCarsStatus() {
        cars.forEach(car -> car.showStatus());
    }

    /**
     * 종료 순서 관리
     */
    void finish() {
        List<Car> finalWinners = getFinalWinners();
        printFinalWinners(finalWinners);
    }

    /**
     * 최종 우승 자동차를 선정
     * @return 우승 자동차
     */
    private List<Car> getFinalWinners() {
        List<Car> winners = new ArrayList<>();

        Integer maxForward = 0;
        for (Car car : cars) {
            if(maxForward < car.getForwardCount()){
                maxForward = car.getForwardCount();
            }
        }

        for (Car car : cars) {
            if(car.getForwardCount() == maxForward){
                winners.add(car);
            }
        }
        return winners;
    }

    /**
     * 최종 우승자 문구 출력
     * @param winners 우승 자동차들의 리스트
     */
    void printFinalWinners(List<Car> winners) {
        StringBuilder finalWinners = new StringBuilder();
        finalWinners.append(winners.get(0).getName());
        winners.remove(0);

        for (Car winner : winners) {
            finalWinners.append(", "+winner.getName());
        }

        System.out.println("최종 우승자 : "+finalWinners);
    }
}
