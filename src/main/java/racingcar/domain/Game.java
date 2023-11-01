package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game{
    List<Car> members = new ArrayList<>();
    public void run(){
        setInputMembers();
    }
    public void setInputMembers(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputMembers = Console.readLine(); //서로 다른 3자리의 수
        //1.members를 분리하여 리스트에 저장

        for(String member:inputMembers.split(",")) {
            Car tmp = new Car(member);
            members.add(tmp);
        }
    }
    public void setAttempts(){

    }
    public void setWinners(){

    }
    public void playGame(){

    }
}
