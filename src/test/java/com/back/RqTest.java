package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RqTest {

    @Test
    @DisplayName("getActionName(\"삭제?id=1\") : 삭제")
    void t1() {

        Rq rq = new Rq("삭제?id=1");

        String actionName = rq.getActionName(); // 삭제

        assertThat(actionName).isEqualTo("삭제");
    }

    @Test
    @DisplayName("getActionName(\"수정?id=1\") : 수정")
    void t2() {

        Rq rq = new Rq("수정?id=1");

        String actionName = rq.getActionName(); // 수정

        assertThat(actionName).isEqualTo("수정");
    }

    @Test
    @DisplayName("입력값 : \"등록?이름=홍길동\" : getParam(\"이름\"): 홍길동")
    void t3() {

        Rq rq = new Rq("등록?이름=홍길동");

        String paramValue = rq.getParam("이름", ""); // 홍길동

        assertThat(paramValue).isEqualTo("홍길동");
    }

    @Test
    @DisplayName("입력값 : \"등록?고향=서울\" : getParam(\"고향\"): 서울")
    void t4() {

        Rq rq = new Rq("등록?고향=서울");

        String paramValue = rq.getParam("고향", ""); // 서울

        assertThat(paramValue).isEqualTo("서울");
    }

    @Test
    @DisplayName("입력값 : \"등록?고향=서울\" : getParam(\"고향\"): 서울")
    void t5() {

        Rq rq = new Rq("등록?고향=서울");

        String paramValue = rq.getParam("이름", "" ); // 이름 가져오라했는데 없을때의 처리

        assertThat(paramValue).isEqualTo("");
    }

    //파라미터 두개 -고향
    @Test
    @DisplayName("입력값 : \"등록?고향=서울&이름=홍길동\" : getParam(\"고향\"): 서울")
    void t6() {

        Rq rq = new Rq("등록?고향=서울&이름=홍길동");

        String paramValue = rq.getParam("고향", "" ); // 이름 가져오라했는데 없을때의 처리

        assertThat(paramValue).isEqualTo("서울");
    }


    //파라미터 두개 - 이름
    @Test
    @DisplayName("입력값 : \"등록?고향=서울&이름=홍길동\" : getParam(\"이름\"): 홍길동")
    void t7() {

        Rq rq = new Rq("등록?고향=서울&이름=홍길동");

        String paramValue = rq.getParam("이름", "" ); // 이름 가져오라했는데 없을때의 처리

        assertThat(paramValue).isEqualTo("홍길동");
    }
}