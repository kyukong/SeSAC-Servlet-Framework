<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        table, td {
            border: 1px solid #444444;
            border-collapse: collapse;
        }

        th {
            background-color: #222222;
            color: white;
        }

        th, td {
            padding: 10px;
            font-size: 20px;
            text-align: center;
        }

        th:first-child, td:first-child {
            width: 30px;
        }

        th:nth-child(2), td:nth-child(2) {
            width: 140px;
        }

        th:nth-child(3), td:nth-child(3) {
            width: 70px;
        }

        a, a:link, a:hover, a:active {
            text-decoration: none;
            color: #BBC8CA;
        }
    </style>
</head>
<body>
<h1>Servlet 실습</h1>
<table>
    <tr>
        <th>No</th>
        <th>제목</th>
        <th>바로가기</th>
    </tr>
    <tr>
        <td>1</td>
        <td>mvc</td>
        <td><a href="/pilot/form">form</a></td>
    </tr>
    <tr>
        <td>2</td>
        <td>가위바위보</td>
        <td><a href="/game/ready">ready</a></td>
    </tr>
    <tr>
        <td>3</td>
        <td>게시글</td>
        <td><a href="/article/list">list</a></td>
    </tr>
</table>
</body>
</html>