## 🏎️ 레이싱 게임

### [✔️] 입력 : 
- 자동차 이름들
- 라운드 횟수 : n
_Scanner 로 입력_
### [✔️] n 번동안 다음을 반복 
_RacingCarPlayer가 다음을 반복_

  - 자동차 별로 랜덤 숫자 생성 k (0 <= k <= 9) 
    - _Racing 에서 랜덤숫자 생성_
  - k가 4이상이면 전진 [✔️]
    - _Racing 에서 Car.move() 호출_
  - 진행 사항 출력 ( 나아간 만큼 '-' 출력 ) [✔️]
    - _Printer_ 
    - _Car.getLocation() 이용_

### [✔️] 최종 우승자 출력
- 우승자 판별
  - _JudgeMachine() 이용_ [✔️]
- 우승자 출력
  - _Printer_ [✔️]


## 📂 폴더링
### ⚙️ configurations : 
_환경설정_
- GameConfigurations
- InputConfigurations
### 🎮 controller : 
_게임기_
- GamePlayer(interface)
- RacingCarPlayer
  - racing car 게임을 실행시킨다.
### 💾 model : 
_자동차 데이터_
- Car
### 🖥️ view
_입,출력_
- Printer : 출력기
- Scanner : 입력기

### 🛠 service
_핵심 로직_
- CarsGenerator : 자동차 생성기 (자동차 이름 이용)
- Racing : 자동차 경주
- JudgeMachine : 결과 판정

