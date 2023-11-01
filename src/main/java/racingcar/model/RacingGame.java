package racingcar.model;

import racingcar.CarDTO;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int numOfRound;
    private List<String> carInputList;
    private Refree refree=new Refree();
    private List<CarDTO> carDTOList = new ArrayList<>();
    private List<Car> CarList=new ArrayList<>();
    public RacingGame(List<String> carInputList,int numOfRound) {
        this.numOfRound = numOfRound;
        this.carInputList = carInputList;
    }

    public void gameStart(){
        carInputListToCarDTO();
        for(int i=0; i<numOfRound; i++){
            playRound();
        }
    }

    public void carInputListToCarDTO(){
        for (String carName : carInputList) {
            carDTOList.add(new CarDTO(carName, 0)); // forwardProgress 값은 0으로 초기화 또는 다른 값으로 설정
        }
    }

    public void CarDTO_TO_CarList(){
        for(CarDTO carDTO : carDTOList){
            CarList.add(new Car(carDTO));
        }
    }

    public void playRound(){
        boolean canForward=false;
        for(Car car : CarList) {
            canForward = refree.ForwardJungement();
            if(canForward==true){
                car.Forward();
            }
        }

    }


}
