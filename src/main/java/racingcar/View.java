package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class View {
    final String RACINGCAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String RACINGCAR_FREQUENCY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private void inputRacingCarNameCheck(String carNames){
        for(String carName : carNames.split(",")){
            if(carName.length()>5){
                throw new IllegalArgumentException();
            }
        }
    }

    private void inputRacingFrequencyNumCheck(String racingFrequencyNum){
        try{ //int값인지 확인, int 범위 내 인지 확인
            Integer.parseInt(racingFrequencyNum);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if(Integer.parseInt(racingFrequencyNum)<1){
            throw new IllegalArgumentException();
        }
    }

    public String racingCarNamesInput(){
        System.out.println(RACINGCAR_NAME_INPUT_MESSAGE);
        String carNames = readLine();
        inputRacingCarNameCheck(carNames);
        return carNames;
    }

    public int racingFrequencyInput(){
        System.out.println(RACINGCAR_FREQUENCY_INPUT_MESSAGE);
        String racingFrequencyNum = readLine();
        inputRacingFrequencyNumCheck(racingFrequencyNum);
        return Integer.parseInt(racingFrequencyNum);
    }
    
}
