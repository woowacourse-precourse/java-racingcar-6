# 🏎️ 우테코 프리코스 2주차 - 레이싱카

## 🔍 목차

- 🚀️ 구현할 기능 목록
- 📦 패키지 구조
- 💡 문제 해결 방안

---

## 🚀️ 구현할 기능 목록

### ✅ **사용자에게 입력 받은 이름 리스트를 통해 자동차 객체를 생성 한다.**

- 자동차 객체가 이름을 가질 수 있도록 생성자를 구성한 `Model` 클래스를 만든다.
- `View` 는 자동차 이름 입력 질문을 출력 후 사용자에게 입력을 받는다.
- `Controller` 는 입력받은 값으로 자동차 일급 컬렉션을 생성한다.
- 자동차 일급 컬렉션은 입력받은 값을 `,`로 분리하여 이름이 있는 자동차들을 켈력션에 저장한다.

### ✅ **사용자에게 입력 받은 횟수 만큼 게임을 반복 한다.**

- `View` 는 횟수 입력 질문을 출력 후 사용자에게 입력을 받는다.
- `Controller` 는 입력받은 값으로 횟수 만큼 아직 만들어 지지 않은 `Game` 이란 것을 반복한다.

### ✅ **게임은 모든 자동차를 조건에 따라 움직인 후 결과를 출력 한다.**

- `Controller` 는 모든 자동차에게 움직이는 행동을 명령한다.
- `View` 는 한 라운드의 결과를 출력한다.

### ✅ **최종 우승자를 출력 한다.**

- 일급 컬렉션은 자동차들을 비교한 뒤 우승자 리스트를 만든다.
- `View` 는 우승자 리스트를 출력한다.

---

## 📦 패키지 구조

<table>
    <tr>
        <th>Package</th>
        <th>Class</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><b>🕹 controller</b></td>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/controller/Race.java">Race</a></b></td>
        <td>경기의 흐름을 총괄 하는 메인 클래스</td>
    </tr>
    <tr>
        <td rowspan="3"><b>🗜️ domain</b></td>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/domain/CarDto.java">CarDto</a></b></td>
        <td>자동차의 이름 및 위치를 담고 있는 DTO 클래스</td>
    </tr>
    <tr>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/domain/CarGroup.java">CarGroup</a></b></td>
        <td>자동차들의 이름과 위치를 관리 하는 일급 컬렉션 클래스</td>
    </tr>
    <tr>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/domain/PlayIterator.java">PlayIterator</a></b></td>
        <td>시도할 횟수 만큼 반복 해주는 반복자 클래스</td>
    </tr>
    <tr>
        <td rowspan="4"><b>🌐 global</b></td>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/global/Constant.java">Constant</a></b></td>
        <td>게임 진행에 필요한 상수를 담은 클래스</td>
    </tr>
    <tr>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/global/ErrorMessage.java">ErrorMessage</a></b></td>
        <td>여러 상황에 대한 예외 메세지를 담은 Enum</td>
    </tr>
    <tr>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/global/GeneralMessage.java">GeneralMessage</a></b></td>
        <td>사용자 질문과 게임 표시에 필요한 입출력 메세지를 담은 Enum</td>
    </tr>
    <tr>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/global/RaceException.java">RaceException</a></b></td>
        <td>경기 전반 예외 상황에 사용될 Exception 클래스</td>
    </tr>
    <tr>
        <td rowspan="2"><b>👁️ view</b></td>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/view/InputView.java">InputView</a></b></td>
        <td>유저의 입력을 받아주는 클래스</td>
    </tr>
    <tr>
        <td><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/view/OutputView.java">OutputView</a></b></td>
        <td>유저에게 질문 또는 게임 결과를 출력하는 클래스</td>
    </tr>
    <tr>
        <td colspan="2"><b><a href="https://github.com/geoje/java-racingcar-6/blob/geoje/src/main/java/racingcar/Application.java">▶️ Application</a></b></td>
        <td>프로그램 시작 지점</td>
    </tr>
</table>

---

## 💡 문제 해결 과정

### 1️⃣ 폴더 구조화

### 2️⃣ MVC 패턴

### 3️⃣ 일급 컬렉션

### 4️⃣ 테스트 코드
