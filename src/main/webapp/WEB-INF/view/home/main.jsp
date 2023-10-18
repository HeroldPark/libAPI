<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<main>
	<nav class="menu text-menu first">
		<h1>메인 메뉴</h1>
        <button onclick="mainRegister()" type="button">등록</button>
        <button onclick="mainSearch()" type="button">찾기</button>
        <button onclick="mainDelete()" type="button">탈퇴</button>

        <script>

            function mainRegister() {
                console.log("mainRegister Start.");

                const inputData = {
                    mode        : "idcardUserReg",
                    userNo      : "1234567893",
                    userName    : '홍길동',
                    userHp      : "010-8901-2788",
                    userBirth   : "1997-11-25"
                }

                $.ajax({
                    url: "<c:url value='/mainRegister'/>",
                    type: "post",
                    data: JSON.stringify(inputData),
                    dataType: "json",
                    contentType: "application/json",
                    success: function(outputData) {
                        alert("성공 : " + outputData.result+ ", " + outputData.tuserNo + ", " + outputData.tuserName + ", " + outputData.tuserHp + ", " + outputData.tuserBirth);
                        console.log("SUCCESS : " + outputData.result+ ", " + outputData.tuserNo + ", " + outputData.tuserName + ", " + outputData.tuserHp + ", " + outputData.tuserBirth);
                    },
                    error: function(errorThrown) {
                        alert("오류: " + errorThrown.statusText);
                    }
                });
            }

            function mainSearch() {
                console.log("mainSearch Start.");

                const inputData = {
                    mode        : "idcardUserSearch",
                    searchType  : "all",             // all, userNo, userName, userBirth
                    searchKey   : "12345",          // userNo, userName, userBirth 의 값 중에서 아무것이나 입력
                    userNo      : "123456789",
                    userName    : '홍길동',
                    userHp      : "010-8901-2788",
                    userBirth   : "1997-11-25"
                }

                $.ajax({
                    url: "<c:url value='/mainSearch'/>",
                    type: "post",
                    data: JSON.stringify(inputData),
                    dataType: "json",
                    contentType: "application/json",
                    success: function(outputData) {
                        for(var i=0; outputData.length; i++) {
                            alert("성공 : " + outputData[i].result+ ", " + outputData[i].tuserNo + ", " + outputData[i].tuserName + ", " + outputData[i].tuserHp + ", " + outputData[i].tuserBirth);
                            console.log("SUCCESS : " + outputData[i].result+ ", " + outputData[i].tuserNo + ", " + outputData[i].tuserName + ", " + outputData[i].tuserHp + ", " + outputData[i].tuserBirth);
                        }
                    },
                    error: function(errorThrown) {
                        alert("오류: " + errorThrown.statusText);
                    }
                });
            }

            function mainDelete() {
                console.log("mainDelete Start.");

                const inputData = {
                    mode : "idcardUserDel",
                    userNo : "123456789",
                }

                $.ajax({
                    url: "<c:url value='/mainDelete'/>",
                    type: "post",
                    data: JSON.stringify(inputData),
                    dataType: "json",
                    contentType: "application/json",
                    success: function(outputData) {
                        alert("성공 : " + outputData.result+ ", " + outputData.tuserNo + ", " + outputData.tuserName + ", " + outputData.tuserHp + ", " + outputData.tuserBirth);
                        console.log("SUCCESS : " + outputData.result+ ", " + outputData.tuserNo + ", " + outputData.tuserName + ", " + outputData.tuserHp + ", " + outputData.tuserBirth);
                    },
                    error: function(errorThrown) {
                        alert("오류: " + errorThrown.statusText);
                    }
                });
            }
        </script>
    </nav>
</main>