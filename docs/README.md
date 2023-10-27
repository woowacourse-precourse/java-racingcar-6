# 기능 구현 목록

## 입력(예외처리 필요)
- [ ] 전진 반복 횟수 : gameController#repetitionNumber
- [ ] 자동차 이름 : car#name
  - [ ] 쉼표(,)로 구분

## 출력
- [ ] 게임시작
  - [ ] 자동차 이름 입력 요청 : view#printAskCarname
  - [ ] 전진 시도 횟수 : view#printAskRepetionNumber
- [ ] 실행결과
  - [ ] 자동차별 전진 시도 결과 / 줄바꿈 : view#printProgressStatus
    - [ ] 전진 반복 시 줄바꿈으로 횟수 간 구분
    - [ ] (이름)v:v(전진시도결과)
  - [ ] 최종 우승자 출력 : view#printWinner
    - [ ] 1명
      - [ ] 최종 우승자 : (이름)
    - [ ] 2명이상
      - [ ] 최종 우승자 : (이름1), (이름2), ...

## 객체, 변수
- [ ] 전진 시도 횟수 : gameController#repetitionNumber
- [ ] 자동차 이름 : car#name
- [ ] 전진 시도 난수 : car#forwardTryRandomNumber
- [ ] 전진 성공 결과 누적 횟수 : car#successForwardCount

## 메서드
- [ ] 시작알림 + 자동차 이름 입력 요청 메시지 프린트 : view#printprintAskRepetionNumber
- [ ] 자동차 이름 입력 / 쉼표 (,) 구분 입력 받기 : view#printAskCarname
  - [ ] 입력 나누기 : controller#splitCarNameInput
  - [ ] 자동차 대수 변수 반환(List.length()로 가능할 듯)
  - [ ] 자동차 대수 만큼 car 객체 생성
  - [ ] 생성된 객체에 자동차 이름 바로 설정 : car#setCarName
- [ ] 전진시도 반복횟수 입력 요청 프린트 : view#printProgressStatus
- [ ] 반복 횟수 저장 : gameData#setRepeitionNumber
- [ ] 반복 실시 : 반복횟수를 조건으로 해서 for loop 생성
  - [ ] 전진시도 과정 숫자 생성(난수) : gameData#createForwardTryRandomNumber
    - [ ] model 객체 별로 횟수 마다 실행
  - [ ] 전진 조건 충족 여부 확인 : controller#verifyMoveForward
  - [ ] 전진 결과 출력 : view#printRaceProgressStatus
- [ ] 입력값 검증 : verify(Input)

- [ ] 최종 우승자 명수 별 객체 처리
  - [ ] 전진 시도 성공 누적 횟수 기준 내림차순 정리 : gameData#setRacingCarList
  - [ ] 누적 성공 횟수 기준 1등과 같은 횟수 있는지 확인 : gameData#CheckOtherWinners
    - [ ] 있으면 : 복수 우승자 이름을 출력 ????
    - [ ] 업으면 : 바로 출력 
- [ ] 최종 우승자 프린트 : view#printWinners


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