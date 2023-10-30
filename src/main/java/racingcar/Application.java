package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.PlayerInput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	PlayerInput InputCarName = new PlayerInput();	

    	
    	System.out.println("차의 회수 : ");
    	int MovingCount = InputCarName.PreMovingCount();
    	System.out.println(MovingCount);
    }
}
