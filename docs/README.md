# 기능 구현 목록

## 입력(예외처리 필요)
- [x] 전진 반복 횟수 : gameController#repetitionNumber
- [x] 자동차 이름 : car#name
  - [x] 쉼표(,)로 구분

## 출력
- [X] 게임시작
  - [x] 자동차 이름 입력 요청 : view#printAskCarname
  - [x] 전진 시도 횟수 : view#printAskRepetionNumber
- [x] 실행결과
  - [x] 자동차별 전진 시도 결과 / 줄바꿈 : view#printProgressStatus
    - [x] 전진 반복 시 줄바꿈으로 횟수 간 구분
    - [x] (이름)v:v(전진시도결과)
  - [x] 최종 우승자 출력 : view#printWinner
    - [x] 최종 우승자 : (이름1), (이름2), ...

## 객체, 변수
- [x] 전진 시도 횟수 : gameController#repetitionNumber
- [x] 자동차 이름 : car#name
- [x] 전진 시도 난수 : car#forwardTryRandomNumber
- [x] 전진 성공 결과 누적 횟수 : car#successForwardCount
- [x] 자동차 리스트 컬렉션 : gameData#successForwardCount


## 메서드
- [x] 시작알림 + 자동차 이름 입력 요청 메시지 프린트 : view#printAskCarname
- [x] 자동차 이름 입력 / 쉼표 (,) 구분 입력 받기 : view#printAskCarname
  - [x] 입력 나누기 : controller#splitCarNameInput
  - [x] 자동차 대수 변수 반환(List.length()로 가능할 듯)
  - [x] 자동차 대수 만큼 car 객체 생성
  - [x] 생성된 객체에 자동차 이름 바로 설정 : car#setCarName
- [x] 전진시도 반복횟수 입력 요청 프린트 : view#printprintAskRepetionNumber
- [x] 반복 횟수 저장 : gameData#setRepeitionNumber
- [x] 반복 실시 : 반복횟수를 조건으로 해서 for loop 생성
  - [x] 전진시도 과정 숫자 생성(난수) : gameData#createForwardTryRandomNumber
    - [x] model 객체 별로 횟수 마다 실행
  - [x] 전진 조건 충족 여부 확인 : controller#verifyMoveForward
  - [x] 전진 결과 출력 : view#printRaceProgressStatus
- [ ] 입력값 검증 : verify(Input)

- [x] 최종 우승자 추출
  - [x] 자동차 객체 별 이동횟수에 따라 컬렉션 순서 내림차순 정렬
  - [x] 1등 자동차 객체의 이동횟수를 추출해 동일한 이동횟수를 가지는 자동차 객체를 별도 winnerList 컬렉션에 저장
- [x] 최종 우승자 프린트 : view#printWinners


## 게임 진행 절차 개요
- 게임 시작 문구 출력
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 작성)
```
- 게임 진행 문구 출력
```
시도할 횟수는 몇회인가요?
```
- 실행 결과 표시
  - 전체 반복 횟수 별로 줄바꿈으로 구분
  -
```
(객체이름) : (전진성공결과누적치)
```

- 반복 완료 후 종료
```
최종 우승자 : (객체1 이름 인스턴수 변수), (객체2 이름 인스턴수 변수), ...
```

# 예외처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시킨 후 애플리케이션 종료
- 잘못된 값 예시 exceptionCheck
  - 자동차이름
    - 알파벳 5개 초과인 경우
    - 쉼표 (,) 이외에 문자 입력된 경우
  - 시도 횟수
    - 숫자 이외의 값 입력된 경우
    - parseInt 하고 예외사항 발생하면 catch로 받아서 예외 throws

테스트 코드 작성