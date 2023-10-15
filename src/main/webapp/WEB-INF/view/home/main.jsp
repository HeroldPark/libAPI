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
            var inputData = {};

            function mainRegister() {
                console.log("mainRegister Start.");

                inputData["mode"] = "idcardUserReg";
                inputData["userNo"] = "123456789";
                inputData["userName"] = "홍길동";
                inputData["userHp"] = "010-8901-2738";
                inputData["userBirth"] = "1997-11-25";

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

                inputData["mode"] = "idcardUserSearch";
                inputData["userNo"] = "123456789";
                inputData["userName"] = "홍길동";
                inputData["userHp"] = "010-8901-2738";
                inputData["userBirth"] = "1997-11-25";

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

                inputData["mode"] = "idcardUserDel";
                inputData["userNo"] = "123456789";
                inputData["userName"] = "홍길동";
                inputData["userHp"] = "010-8901-2738";
                inputData["userBirth"] = "1997-11-25";

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