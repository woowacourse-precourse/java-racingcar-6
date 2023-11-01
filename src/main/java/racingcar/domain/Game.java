package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game{
    List<Car> members = new ArrayList<>();
    Checker checker=new Checker();
    static String inputMembers="";
    static String inputAttempts="";
    static int attempts=0;
    public void run(){
        setInputMembers();
        makeMembers();
        setAttempts();
    }
    public void setInputMembers(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputMembers = Console.readLine(); //서로 다른 3자리의 수
        //1.members를 분리하여 리스트에 저장
    }
    public void makeMembers(){
        for(String member:inputMembers.split(",")) {
            checker.checkMember(member);
            Car car = new Car(member);
            members.add(car);
        }
    }
    public void setAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        inputAttempts = Console.readLine();
        checker.checkNumber(inputAttempts);
    }

    public void setWinners(){

    }
    public void playGame(){

    }
}
