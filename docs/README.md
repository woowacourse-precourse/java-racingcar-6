# 1. 기능 명세서
## 입력
- [x] 사용자로부터 자동차 이름 입력받는 readCarNames() 메서드 작성
- [x] 사용자로부터 시도 횟수 입력받는 readTryNum() 메서드 작성
## 출력
- [x] 각 차수별 실행 결과 출력하는 printCarMoveResult() 메서드 작성
- [x] 우승자 출력하는 printWinner() 메서드 작성
## 로직
- [x] 0~9 사이 난수를 뽑아오는 getRandNum() 메서드 작성
- [x] 전진일 경우 '-' 추가하는 addDash() 메서드 작성
- [x] 우승자 추려내는 getWinner() 메서드 작성

# 2. 예외 처리
- [x] 자동차 이름이 5글자를 초과한 경우 ex) helloworld
- [x] 구분자로 쉼표가 아닌 다른 문자를 사용한 경우 ex) car1.car2
- [x] 이동 횟수가 수가 아닌 문자인 경우 ex) five
- [x] 입력하지 않은 경우 ex) "" 
- [x] 자동차 이름을 하나만 입력한 경우 ex) car1
- [x] 자동차 이름이 중복되는 경우 ex) car1,car1,car2
- [x] 이동 횟수가 0이 들어온 경우 ex) 0