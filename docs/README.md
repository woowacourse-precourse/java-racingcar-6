## 🏎️ 레이싱 게임

### [✔️] 입력 : 
- 자동차 이름들
- 라운드 횟수 : n
_Scanner 로 입력_
### [✔️] n 번동안 다음을 반복 
_RacingCarPlayer가 다음을 반복_
  - 자동차 별로 이동 [✔️]
    - _Car.move()_  
  - 자동차 별로 랜덤 숫자 생성 k (0 <= k <= 9) 
  - k가 4이상이면 전진 [✔️]
    - _RandomEngine_  
  - 자동차 별로 진행 사항 출력 ( 나아간 만큼 '-' 출력 ) [✔️]
    - _Printer_ 
    - _Car.getLocation() 이용_

### [✔️] 최종 우승자 출력
- 우승자 판별
  - _JudgeMachine() 이용_ [✔️]
- 우승자 출력
  - _Printer_ [✔️]


## 📂 폴더링
### ⚙️ configurations : 
환경설정
- GameConfigurations
- InputConfigurations
### 🎮 controller : 
게임기 
- GamePlayer(interface)
- RacingCarPlayer
  - racing car 게임을 실행시킨다.
### 💾 model : 
자동차 데이터
- Car 
- Engine (interface, 자동차는 엔진에 의해 움직인다.)
  - 요구사항에 맞게 engine 인터페이스를 구현한 클래스를 만든다.
- RandomEngine (요구사항에 맞게 자동차를 움직이게 해준다.)
### 🖥️ view
입,출력
- Printer : 출력기
- Scanner : 입력기

