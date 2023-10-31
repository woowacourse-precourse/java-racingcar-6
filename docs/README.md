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

- 1주차 에는 클래스를 따로 1개만 만들고 `Application.java` 에 모든 것을 함수화 하였습니다.
- 다른 분들의 코드 리뷰를 보고 좀 더 구조화 하기 위해 프로젝트 시작 때 폴더 구조를 MVC 패턴에 맞도록 설계 하였습니다.
- 그리하여 `controller` `domain` `global` `view` 총 4개의 폴더를 생성 하였습니다.

### 2️⃣ MVC 패턴

- 유저와의 입출력을 담당하는 `View`, 데이터를 담당하는 `Model`, 그 사이 중재자 `Controller` 를 분리하여 각자의 역할을 다른 요소가 알 필요가 없이 유연한 구조를 가지도록 설계하는데
  집중하였습니다.
- 처음 만들 당시 폴더가 구조화 되어 가시성이 높아진 부분만 장점으로 느꼈지만 이후 진행 했던 테스트 코드 작성 부분 부터 다른 문제들을 해결함에 있어 이점을 확실히 알게 되었습니다.

![](https://velog.velcdn.com/images/chch1213/post/c02941aa-31d7-4c21-bfef-46cf3ef7cf00/image.png)

### 3️⃣ 일급 컬렉션

- `String` 형태의 이름, `Integer` 형태의 위치 를 가지고 있는 `CarDto` DTO를 요소로하는 일급 컬렉션 `CarGroup` 을 만들었습니다.
- 일급 컬렉션을 `MVC 패턴` 에서 `Model` 쪽이라 생각하였고 직접적인 리스트 접근을 막기 위해 모든 자동차를 확률적으로 한번 움직이는 `moveAllProbabilistically` 함수, 현재 상태 또는
  우승자 리스트를 문자열로 반환해주는 `getStatusAsString` `getWinnerAsString` 함수를 만들었습니다.
- 해당 문자열을 만드는 것은 `View` 에서 해야하나 고민도 많았지만 `View` 는 단순 출력만 하고 일급 컬렉션이 데이터 공개를 최소화 하기 위해 이러한 설계를 택하였습니다.

### 4️⃣ 테스트 코드

- 테스트 코드를 처음 사용해 봤지만 비슷한 테스트에 필요한 놀라운 재사용 가능성, 비지니스 로직 수정에 대해 다시 테스트하기 위한 반복 가능성이 정말 좋았습니다.
- ⭐ **테스트 코드를 통한 빠른 오류 파악 후 일급 컬렉션의 자료구조 변경**
    - 첫 설계에서는 일급 컬렉션의 자료 구조를 `HashMap<String, Integer>` (`Key` 는 자동차의 이름, `Value` 는 자동차의 위치)로 구성하였습니다.
    - 하지만 아래와 같이 `HashMap`의 특성에 따라 `Key` 가 랜덤으로 저장되는 특징은 간과하여 자동차 이름이 입력된 순서대로 출력되지 않는 문제가 발생하였습니다.
    - ![](https://velog.velcdn.com/images/chch1213/post/82cb3166-710f-4c37-bd0b-90bfb39432f0/image.png)
    - `HashMap<String, Integer` 를 바꾸기 위해 `CarDto` 를 급하게 만들고 `List<CarDto>` 변경하였습니다.
    - 평소 `MVC패턴` 을 적용하지 않고 개발을 하다 보니 이러한 변동 사항이 생길 때 코드 변경 사항이 많아 걱정을 했었지만 이번 수정에서는 딱 `CarGroup` 일급컬렉셔만 수정하니 모든 오류가 고쳐지고
      테스트가 정상 수행된는 것을 확인할 수 있었습니다.
    - ![](https://velog.velcdn.com/images/chch1213/post/61f2b054-20e4-43c0-96ee-4af6705b806d/image.png)
    - 이로써 테스트 코드 작성과 MVC 패턴에 대한 큰 장점을 몸소 알 수 있었고, 앞으로의 개발에서도 꾸준히 객체 하나마다 예외 사항들을 생각하여 테스트 코드를 작성하며 각 컴포넌트들이 각각 자신의 역할을
      수행할 수 있도록 분리하여 MVC 패턴을 잘 적용 시킬 것입니다.