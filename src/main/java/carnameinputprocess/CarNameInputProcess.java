package carnameinputprocess;

public class CarNameInputProcess {

    public CarNameInputProcess(String carname) {
        seperateInputName(carname);
    }

    // 입력받은 이름분류, 검사 메소드
    private void seperateInputName(String carname) {
        String[] carnames = carname.split(",");
        inspectName(carnames);
    }

    // 검사 실행 메소드
    private void inspectName(String[] carnames) {
        validInputSting(carnames);
        checkNameState(carnames);
    }


    // 차 이름 들어왔나 확인
    private void validInputSting(String[] carnames) throws IllegalArgumentException {
        if (carnames.length == 0) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(',' 을 기준으로 구분하는 5자 이하의 이름을 입력해주세요)");
        }
    }

    // 차 이름이 들어왔을 경우, 각 이름에 대한 조건(5자 이하) 메소드 호출
    private void checkNameState(String[] carnames) {
        for (int i = 0; i < carnames.length; i++) {
            checkNameItemlength(carnames[i]);
            checkNameItem(carnames[i]);
        }
    }

    // 공백의 이름인지 확인
    private void checkNameItem(String carnameItem) throws IllegalArgumentException {
        if( carnameItem.isBlank() ) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(공백이 아닌 이름을 입력해주세요.)");
        }
    }

    // 5자 이하인지 확인
    private void checkNameItemlength(String carnameItem) throws IllegalArgumentException {
            if (carnameItem.length() > 5) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(각 이름은 5자 이하로 입력해주세요)");
            }
    }
}