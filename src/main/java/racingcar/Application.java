package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Computer InputCarName = new Computer();	

    	
    	System.out.println("차의 회수 : ");
    	int MovingCount = InputCarName.RandomComputerNum();
    	System.out.println(MovingCount);
    }
}
