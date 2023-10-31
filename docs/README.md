# 기능 목록

## 자동차 경주 앱 - RacingApp
### 필드
- 시행 횟수 - executeCount
- 자동차 리스트 - racingCarList
### 메서드
- 이름 입력 받기 - getPlayerList
- 시도 횟수 입력 받기 - getExecuteCount
- 횟수만큼 실행하기 - play
- 최종 우승자 목록 출력하기 - printRacingResult

## 자동차 리스트 - RacingCarList
### 필드
- 자동차 리스트 - racingCarList
### 메서드
- 입력 받은 값으로 자동차 리스트 생성하기 (생성자)
- 시행횟수 1번 시행하기 - executeOneStep
- 시행 1회당 결과 출력하기 - printRacingCarsCurrentStatus
- 자동차 리스트 중에서 가장 많이 움직인 칸수 구하기 - getMaxForward
- 자동차들 중 우승자 목록 구하기 - getWinnerList

## 자동차 - RacingCar
### 필드 
- 현재 몇칸 움직였는지 - count
- 이름 - name
### 메서드
- 자동차 이름 출력 - getName
- 현재 움직인 칸수 출력 - getCount
- 자동차 이름 조건 검증 - validateName
- 자동차 이동 함수 - moveOneBlock
- 자동차 1개의 현재 상태 출력하기 - printCurrentResult (ex : "pobi : ---")
