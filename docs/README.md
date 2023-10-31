# [우아한테크코스 프리코스 2주차] 자동차 경주

## 기능 요구 사항

### 입력

1. 자동차 이름은 `,`로 구분, 5자 이하
2. 이동 횟수(스테이지 수) 지정
3. 잘못된 값을 입력한 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료

### 게임

1. 스테이지마다 자동차는 전진 혹은 멈춤
2. 전진 조건은 0에서 9사이에서 구한 무작위 값이 4 이상인 경우

### 출력

1. 각 스테이지가 끝나고 실행 결과를 보여줄 때 자동차 이름을 함께 출력
2. 게임 종료 후 우승자를 발표하고 우승자가 여러 명인 경우 `,`를 사용해 구분

## 구현 기능

1. 게임 시작

- 자동차 이름 입력 문구를 출력
- 횟수 입력 문구를 출력

2. 입력

- 자동차 이름을 입력
- 횟수를 입력
- 잘못된 값이 입력되면 예외 발생 후 종료
    - 자동차 이름: 5자 이상
    - 횟수: 숫자가 아님

3. 게임 진행

- 입력된 횟수만큼 스테이지 반복
    1. 각 자동차마다 전진 혹은 정지 여부를 판단
    2. 해당 스테이지 종료 후의 결과 출력

4. 게임 종료

- 우승자를 판별해 결과 출력

## 구현 클래스와 메서드

### /model

- 데이터를 가진 객체
- CRUD

규칙

1. 편집하기 원하는 모든 데이터를 갖고 있음
2. 뷰나 컨트롤러와는 독립되어 관련된 어떤 정보도 알고 있지 않음
3. 변경 발생시 변경 통지에 대한 처리 방법을 구현해야 함

#### Game.java

게임에 대한 정보를 가진 클래스

- getCars(): HashMap<String, Integer> cars를 return
- addCar(String name): cars에 새로운 차를 추가
- editStatus(String key): cars에 저장된 차의 값을 변경

### /view

- 요청을 받아 화면 구성
- 사용자와 상호작용

규칙

1. 모델이 가진 데이터를 저장해서는 안 됨
2. 모델이나 컨트롤러 등의 다른 구성 요소를 몰라야 함
3. 변경 발생시 변경 통지에 대한 처리 방법을 구현해야 함

#### InputView

입력과 관련된 클래스

- inputCarNames(): 차 이름을 입력 받아 유효성을 검증하고 반환
- inputStageTimes(): 이동 횟수(= 스테이지 수)를 입력 받아 유효성을 검증하고 반환

#### PrintView

출력과 관련된 클래스

- inputCarNamesMessage(): 차 이름을 입력하라는 안내 문구 출력
- inputStageTimesMessage(): 이동 횟수를 입력하라는 안내 문구 출력
- initialStageResultMessage(): 게임 시작 후 최초 한 번만 "실행 결과" 출력
- stageResultMessage(ArrayList<String> list): 각 스테이지의 결과값 출력
- winnerResultMessage(ArrayList<String> winners): 게임의 최종 결과값 출력

### /controller

- 모델과 뷰를 이어주는 인터페이스
- 사용자의 입력 처리 및 응답 담당

규칙

1. 모델이나 뷰에 대해서 알고 있음
2. 모델이나 뷰의 변경을 모니터링

#### GameController

전반적인 게임을 진행하는 클래스

- runGame(): 게임을 순서에 맞게 실행
- returnWinners(): 우승자를 판별 및 출력 지시

#### InputController

입력과 관련된 클래스

- inputCarNames(): 입력 받은 차 이름을 저장
- inputStageTimes(): 입력 받은 이동 횟수(= 스테이지 수)를 저장

#### StageController

스테이지를 진행하는 클래스

- runStage(): 전진 혹은 정지 여부를 통해 status(HashMap의 value값) 값을 변경
- returnStageResult(): 스테이지 실행 결과 출력을 지시
- initialStageResult(): 게임 시작 후 최초 한 번만 "실행 결과" 출력 지시

### /service

- 컨트롤러의 호출에 따라 실질적으로 요청을 수행

#### GameService

게임과 관련된 로직을 갖고 있는 클래스

- checkWinners(HashMap<String, Integer> cars): status값을 비교해 우승자를 판별 후 반환

#### StageService

- stageProcess(): 임의의 수를 생성해 전진 혹은 정지 여부를 결정 후 반환
- checkStageResult(HashMap<String, Integer> cars): 스테이지 종료 후 각 차의 결과 반환

### /util

- 자주 사용하는 util 메서드 정리

#### GameUtil

게임과 관련된 util

- createRandomNumber(): 0에서 9사이의 임의의 수를 생성
- moveOrStop(int number): 입력된 수가 4 이상인지 판별

#### FormatUtil

출력값에 맞게 가공하는 util

- statusFormat(int number): status(전진 횟수)를 토대로 출력값에 맞게 "-"를 반복해 반환
- stageResultFormat(String car, String status): 스테이지 종료 후의 결과값을 출력값에 맞게 가공해 반환
- winnerResultFormat(ArrayList<String> winners): 게임 종료 후의 결과값을을 출력값에 맞게 가공해 반환

#### StringUtil

- splitString(String string): `,`로 구분된 차 이름을 사용하기 편한 자료 구조로 반환

#### Validator

유효성 검증을 위한 클래스

- nameLengthLimit(String name): 5글자 이상, 0글자 이하인 이름은 예외 처리
- isNumber(String input): 숫자가 아닌 이동 횟수는 예외 처리

### /constant

- 상수값 저장
- enum class 활용

## 구현 테스트

1. 이름_공백_제거_확인

- 입력한 이름 사이에 공백이 있는 경우 제거 되는지 확인

2. 차_이름_입력_확인

- 쉼표로 구분한 자동차 이름이 정상적으로 입력 되는지 확인

3. 숫자가_아닌_횟수_예외처리

- 이동 횟수가 숫자가 아닌 경우 IllegalArgumentException을 throw 하는지 확인