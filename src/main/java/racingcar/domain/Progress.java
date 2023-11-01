package racingcar.domain;

public class Progress {
    public Progress(){

    }
    public void moveProgressPrint(Car car){
        System.out.println(car.getName()+" : "+car.getViewProgress());
    }


}
