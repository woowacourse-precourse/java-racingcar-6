package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game{
    List<Car> members = new ArrayList<>();
    Checker checker=new Checker();
    static String inputMembers="";
    static String inputAttempts="";
    static int attempts=0;
    static int maxDistance=0;
    static String winners = "최종 우승자 :";
    public void run(){
        setInputMembers();
        makeMembers(inputMembers);
        setAttempts();
        makeAttempts(inputAttempts);
        startAttempts();
        setMaxDistance();
        createWinners();
        showWinners();
    }
    public void setInputMembers(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputMembers = Console.readLine();
    }
    public void makeMembers(String inputMembers){
        for(String member:inputMembers.split(",")) {
            checker.checkMembers(member);
            Car car = new Car(member);
            this.members.add(car);
        }
    }
    public void setAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        this.inputAttempts = Console.readLine();
    }
    public void makeAttempts(String inputAttempts){
        checker.checkAttempts(inputAttempts);
        this.attempts = Integer.parseInt(inputAttempts);
    }
    public void startAttempts(){
        System.out.println("실행 결과");
        while(attempts!=0){
            attempts -= 1;
            playGame();
            showGame();
            System.out.print("\n");
        }
    }
    public void playGame(){
        for(Car car:members) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if(randomNumber >= 4){
                car.go();
            }
        }
    }
    public void showGame(){
        for(Car car:members) {
            car.display();
        }
    }
    public void setMaxDistance(){
        for(Car car:members){
            int newMaxDistance = car.compareMaxDistance(maxDistance);
            if(newMaxDistance!=0){
                maxDistance=newMaxDistance;
            }
        }
    }
    public void createWinners(){
        for (Car car:members) {
            winners = car.addWinner(maxDistance,winners);
        }
    }
    public void showWinners(){
        if (winners.endsWith(",")) {
            winners = winners.substring(0, winners.length() - 1);
        }
        System.out.println(winners);
    }
}
