package racingcar.Model;

public class Car {
    private final String name;  //차의 이름
    private int CurrentLocation = 0;  //현재 위치

    public Car(String name){   //생성자
        this.name = name;
    }

    public String getCarName(){  //차의 이름 받아온다.
        return name;
    }

    public void decisionToMove(int randomNumber){  // 이동할지 결정
        if (4 <= randomNumber){
            move();
        }
    }

    public void move(){  // 이동
        CurrentLocation++;
    }

    public int getCurrentLocation(){
        return CurrentLocation;
    }
}