package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CarInformation;
import view.OutputPhrase;

import static model.Constants.STANDARD_NUMBER_OF_ATTEMPTS;
import static model.Constants.FORWARD;
public class RacingCarGameLogic {

    CarInformation carInformation = new CarInformation();
    OutputPhrase outputPhrase = new OutputPhrase();
    List<String> carNames = new ArrayList<>();
    List<Integer> carForwardCount = new ArrayList<>();
    public void insertCarName(String[] carName){
        carNames.addAll(Arrays.asList(carName));
        countInitialSettings(carNames.size());
        carInformation.setCarNames(carNames);
    }

    public void checkFrontAttempts(){
        getCarInformation();
        generateCarForwardCount();
        for(int i=0;i<carNames.size();i++){
            String dash=convertCountToDash(carForwardCount.get(i));
            outputPhrase.outputProgressMessage(carNames.get(i),dash);
        }
        outputPhrase.outputRunOnce();

    }

    public void getCarInformation(){
        carForwardCount=carInformation.getCarForwardCount();
        carNames=carInformation.getCarNames();
    }

    private void generateCarForwardCount(){
        for(int i=0;i<carNames.size();i++){
            compareToFrontCount(Randoms.pickNumberInRange(0,9),i);
        }
    }

    private void compareToFrontCount(int randomNumber,int index){
        carForwardCount=carInformation.getCarForwardCount();
        if(randomNumber>=STANDARD_NUMBER_OF_ATTEMPTS){
            carForwardCount.set(index,carForwardCount.get(index)+1);
        }
    }

    private String convertCountToDash(int count){
        String dash="";
        for(int i=0;i<count;i++){
            dash+=FORWARD;
        }
        return dash;
    }

    public void countInitialSettings(int carNamesSize){
        for(int i=0;i<carNamesSize;i++){
            carForwardCount.add(0);
        }
        carInformation.setCarForwardCount(carForwardCount);
    }
}
