<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css"></link>
    <script src="js/main.js" type="module" defer></script>
    <title>Document</title>
</head>
<body>
    <table width="100%" border="0">
        <tr>
            <td colspan=3 width="100%">
                <table class=header-list width="100%">
                    <tr height=30px>
                        <th align = "center">Имя</th>
                        <th align = "center">Группа</th>
                        <th align = "center">Вариант</th>
                    </tr>
                    <tr>
                        <td align = "center">Башлачёв А.П.</td>
                        <td align = "center">P3231</td>
                        <td align = "center">1368</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr height="100px">

        </tr>
        <tr>
            <td width="30%" class="left-table">
                <table>
                    <tr>
                        <td>
                            <form action="#" method="GET" id="form">
                                <table width="100%">
                                    <tr height="30px">
                                        <td class="option-label"> X </td>
                                        <td>
                                            <table width="100%">
                                                <tr>
                                                    <td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=-5> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=-4> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=-3> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=-2> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=-1> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=0> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=1> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=2> </input> </label> </td>
                                                        <td> <label class="x-option"> <input class="x-button" type="button" name="x" value=3> </input> </label> </td>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="option-label"> Y </td>
                                        <td>
                                            <input type="text" id="y-text" class="text-input" placeholder=" -3...3" autocomplete="off"> </input>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="option-label"> R </td>
                                        <td>
                                            <select name="r" id="r-select">
                                            <option value=""> choose r </option>
                                            <option value="1">1</option>
                                            <option value="1.5">1.5</option>
                                            <option value="2">2</option>
                                            <option value="2.5">2.5</option>
                                            <option value="3">3</option>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td></td>
                                        <td align="center">
                                            <button type="submit" id="submit-button">submit</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                    <tr height="100px">
                        <td align="center">
                            <p id="error-field"></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width="100%" id="result-table" border="1px">
                                <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>X</th>
                                        <th>Y</th>
                                        <th>R</th>
                                        <th class="wide-col">script time</th>
                                        <th>result</th>
                                    </tr>
                                </thead>
                                <tbody id="result-table-body">
                                    <%
                                    java.util.ArrayDeque<resources.Submission> results = (java.util.ArrayDeque<resources.Submission>) application.getAttribute("results");
                                    if (results != null){
                                        for(resources.Submission r: results){
                                            %>
                                            <tr>
                                                <td><%=r.getId()%></td>
                                                <td><%=r.getPoint().getX()%></td>
                                                <td><%=r.getPoint().getY()%></td>
                                                <td><%=r.getPoint().getR()%></td>
                                                <td><%=r.getScriptTime()%></td>
                                                <td><%=r.getResult()%></td>
                                            <tr>
                                    <%
                                        }
                                    }
                                    %>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>

            <td width="10%">

            </td> 

            <td width="60%">
                <canvas id="graph" height="800" width="800">

                </canvas>
            </td>
        </tr>
    </table>
</body>
</html>