# 구현한 기능 목록


## 자동차 정보 `Car` 클래스
- 목적: 자동차 이름, 위치 정보 저장
- Field이름(`String`), 위치(`Integer`), 숫자 판별(`Numbers`)
- Method
  - 차종별 시도(`void` &rarr; `void`)
  - 차종별 움직임 출력(`void` &rarr; `void`)
  - 차종별 이름 get(`void` &rarr; `String`)

### 차종별 출력
`this.name` : `"-".repeat(this.position)` 꼴로 출력

### 차종별 시도
1. 랜덤한 0~9 사이 숫자 생성
2. 숫자 판별(`Numbers.compareFour`) 함수로 체크
3. 판별 후 `this.position += 0 || 1`

## 숫자 판별 `Numbers` 클래스
- 목적: if 문을 대신 하기 위해 `HashMap`를 이용하여 0~9 를 key 값으로 두고 value로 increasement
- Field: map(`Map<Integer, Integer>`)
- Method: 숫자 판별(`int` &rarr; `int`)

### 숫자 판별
map에서 해당 value를 리턴


## 레이싱 시작 및 종료 `Racing` 클래스
- 목적: 레이싱 시작과 종료를 모듈화하기 위한 클래스
- Field: 차량 목록(`List<Car>`), 시행 횟수(`int`)
- Method
  - 정보 입력(`void` &rarr; `void`)
  - 레이싱 시작(`void` &rarr; `void`)
  - 결과 출력(`void` &rarr; `void`)
  - 승자 판별(`void` &rarr; `List<Cars>`)
  - 승자 출력(`void` &rarr; `void`)

### 정보 입력
차량 이름 목록을 공백 없이 쉼표(`,`)로 구분 하여 입력 &rarr; 시행 횟수를 다음 줄에 입력

### 레이싱 시작
입력한 시행 횟수 만큼 차량별 시도

### 결과 출력
차량별 현재 위치 출력

## 유효성 검사
- 어노테이션을 사용하여 유효성 검증

### 어노테이션
- 메소드, 런타임에 동작

### 유효성 검증 클래스
- 목적: 이름이 5글자 이하인 경우, 시행 횟수를 정수가 아닌 다른 형식으로 입력한 경우

## 입력 인터페이스 및 구현
- 유효성 검사를 모듈화하기 위한 용도