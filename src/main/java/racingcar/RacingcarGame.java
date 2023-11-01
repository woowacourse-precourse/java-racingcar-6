package racingcar;

import java.util.LinkedList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingcarGame {

    public List<Car> carList;
    int totalGameCount;
    int furthestDistance;
    public RacingcarGame(){
        carList = new LinkedList<>();
        totalGameCount=-1;
        furthestDistance=-1;
    }
    public RacingcarGame(List<Car> carList, int totalGameCount, int furthestDistance){
        this.carList = carList;
        this.totalGameCount=totalGameCount;
        this.furthestDistance= furthestDistance;
    }
    public void startRacingGame(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputText = getInputText();
        setRacingCar(inputText);
        System.out.println("시도할 회수는 몇회인가요?");
        this.totalGameCount = Integer.parseInt(getInputText());

        System.out.println("실행 결과");
        doGame(0);

        System.out.print("최종 우승자 : ");
        printWinner();
    }
    public String getInputText(){
        return readLine();
    }
    public void setRacingCar(String inputText){
        String[] carNames = inputText.split(",");
        if(carNames.length == 0)
            throw new IllegalArgumentException();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    // 재귀
    public void doGame(int currentGameCount){
        //총 게임 횟수를 채우면 종료
        if (currentGameCount>=this.totalGameCount)
            return;

        //모든 자동차가 전진 할지 여부 결정
        for (Car car : carList) {
            car.goOrNot();
            //가장 멀리 이동한 거리 저장
            if (car.distance > furthestDistance)
                this.furthestDistance = car.distance;
        }

        printGameResult();

        doGame(++currentGameCount);
    }

    public void printGameResult(){
        for (Car car : carList) {
            System.out.print(car.name + " : ");
            printDash(car.distance);
            System.out.println();
        }
        System.out.println();

    }

    public void printDash(int distance){
        for(int i=0; i<distance; i++){
            System.out.print("-");
        }
    }

    public void printWinner(){

        int count=0;

        for (Car car : carList) {
            if ((count == 0) && (car.distance == furthestDistance)) {
                System.out.print(car.name);
                count++;
            } else if (car.distance == furthestDistance){
                System.out.print(", " + car.name);
                count++;
            }
        }
    }
}
