# 자동차 경주 기능 목록

### 사용자 입력 validation
- 자동차 이름
    * 모든 자동차 이름의 길이가 5이하인지 확인
    * 하나라도 어긋난다면 `IllegalArgumentException` 발생
- 이동할 횟수
    * 숫자가 아니라면 `IllegalArgumentException` 발생
    * 0 미만의 숫자라면 `IllegalArgumentException` 발생

---

### 사용자 입력 받아오기
- 안내 문구 출력 후 변수에 각 정보 저장
- 자동차 이름의 경우 최종적으로 객체에 저장하므로 여러 번의 가공 필요

---

### 랜덤 선택
- 0 ~ 9 사이에 속하는 무작위의 숫자가 4이상이면 `true` 아니면 `false`

---

### 경주 진행
- 랜덤 선택 기능을 통해 무작위로 Stop 또는 MovingForward
- MovingForward에 해당하는 차들의 state(String)에 "-"를 더함

---

### 중간 결과(상태) 출력
- 각 객체에 저장된 정보를 정해진 츨력 형식에 맞게 출력
    * 출력 형식: `{carName} : {carState}`
- Class 예시)
    * Car { String name, String state };

---

### 우승자 도출
- 가장 많이 나아간 자동차 이름들을 String으로 저장
- 가장 긴 state를 가진 자동차가 여러 대일 경우 공동 우승

---

### 최종 결과(승리자) 출력'
- 가장 많이 나아간 자동차 이름들을 정해진 출력 형식에 맞게 출력
    * 출력 형식: `최종 우승자 : {carNames}`