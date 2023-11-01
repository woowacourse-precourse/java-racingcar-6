# [미션2] Racing-car

## Race
- Car list : 자동차 리스트
- time : 시도 횟수

### method
- 유효한 횟수인지 확인(양의 정수) ; isValidTime
- 한 라운드 실행 ; runRound
- 경주가 계속 실행될 것인지 확인 ; isRunning
- 한 라운드 결과 반환 ; getResult
- 경주 종료 후, 우승자 구하기 ;getWinners

## Car
- name : 이름
- number of move : 이동횟수

### method
- 유효한 자동차 이름인지 확인(5자 이하, not 빈 문자열) ; isInvalidName 
- 전진하는 함수 ; moveFoward

## Screen
 화면 입출력 클래스
 - 자동차 이름 입력받기
 - 시도 횟수 입력받기
 - 한 라운드 별 실행 결과 출력
 - 우승자 출력
 