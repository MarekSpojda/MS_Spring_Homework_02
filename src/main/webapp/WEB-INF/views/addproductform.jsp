<%--suppress HtmlUnknownTarget --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/processproduct" method="get">
    <label>Wybierz produkt
        <select name="choosenproduct">
            <option value="1">Gruszki</option>
            <option value="2">Jabłka</option>
            <option value="3">Skarpetki</option>
            <option value="4">Landrynki</option>
        </select>
    </label><br>

    <label>Podaj ilość
        <input type="number" name="quantity" step="1" min="1" value="1">
    </label><br>

    <input type="submit" value="Wprowadź produkt">
</form>

</body>
</html>
