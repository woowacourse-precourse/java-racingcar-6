Controller
자동차의 생성, 이동 및 우승자 발표, 사용자와 상호 작용(입력 및 출력)을 처리

createCars(String inputNames): 쉼표로 구분된 자동차 이름을 입력으로 받아, 자동차 객체를 생성하고 리스트에 저장
moveCars(): 목록에 있는 각 자동차를 난수 생성을 기반으로 이동시킴
getCars(): 자동차 목록을 반환
getWinners(): 레이스의 우승자를 결정하고 그들의 이름을 반환
startRacingCarGame(): 사용자에게 입력을 요청하고, 레이스를 시뮬레이션하며, 우승자를 발표하는 게임을 시작

Model
각 자동차는 이름과 위치를 가지고 있으며 위치는 이동할 때 업데이트

공개 메서드
getName(): 자동차의 이름을 반환
getPosition(): 자동차의 현재 위치를 반환
move(): 난수가 4 이상인 경우 자동차가 한 칸 앞으로 진행

View
현재 자동차 상태를 출력하고 우승자를 발표하는 역할

공개 메서드
printCarStatus(Car car): 자동차의 현재 상태를 출력하며, 이름과 위치의 시각적 표현을 표시
printWinners(List<String> winners): 레이스의 우승자를 출력, 우승자가 하나인 경우 이름을 발표하고, 여러 명인 경우 이름을 나열