# 기능 목록 구현
- [X] 매 회수 마다 자동차들 전진하는 기능
  - [X] 0 ~ 9 무작위 값 중 4 이상인 경우 전진
  - [X] racing 반복 회수 설정
- [X] 우승차 판별 기능
  - [X] 전진 길이 최대값 구하기
  - [X] 우승자 리스트 출력

# 입출력 기능
- [X] 자동차 이름 입출력 기능(5 자 이하)
- [X] 레이싱 반복 회수 입출력 기능
- [X] 실행 결과 반복 출력 기능
  - [X] 각 car 객체 전진 회수만큼 "-" 출력
- [X] 최종 우승자 출력 기능

# Exception
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 기능
  - [x] 경주 반복 회수가 0 이하일 경우 Exception 발생
  - [X] 자동차 이름이 5자 이하가 아닐 경우 Exception 발생

# 내부 API
  - 입력 기능 -> **camp.nextstep.edu.missionutils.Console의 readLine()**
  - RandomNumber 사용 -> **camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()**