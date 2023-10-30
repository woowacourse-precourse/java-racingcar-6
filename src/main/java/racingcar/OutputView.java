package racingcar;

public class OutputView {
    public void carNameMessage(){
        System.out.println(InputMessage.CAR_NAME);
    }

    public void countMessage(){
        System.out.println(InputMessage.COUNT);
    }

    public void carPositionMessage(String name, int position){
        System.out.println(name + " : " + OutputMessage.DISTANCE.repeat(position));
    }
}
