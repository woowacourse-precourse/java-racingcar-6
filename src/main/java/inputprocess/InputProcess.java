package inputprocess;

import org.mockito.internal.util.Checks;

public class InputProcess {

    public InputProcess(String carname) {
        SeperateInputName(carname);
    }

    // 입력받은 이름분류, 검사 메소드
    private void SeperateInputName(String carname) {
        String[] carnames = carname.split(",");
        InspectName(carnames);
    }

    // 검사 메소드
    private void InspectName(String[] carnames) {
        ValidInputSting(carnames);
        CheckNameState(carnames);
    }


    // 차 이름 들어왔나 확인
    private void ValidInputSting(String[] carnames) throws IllegalArgumentException {
        if (carnames.length == 0) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(',' 을 기준으로 이름을 입력해주세요)");
        }
    }

    // 차 이름이 들어왔을 경우, 각 이름에 대한 조건(5자 이하) 메소드 호출
    private void CheckNameState(String[] carnames) {
        for (int i = 0; i < carnames.length; i++) {
            CheckNameItem(carnames[i]);
        }
    }

    // 5자 이하인지 확인
    private void CheckNameItem(String carnameItem) throws IllegalArgumentException {
            if (carnameItem.length() > 5) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(각 이름은 5자 이하로 입력해주세요)");
            }
    }
}