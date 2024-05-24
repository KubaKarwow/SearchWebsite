<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
    <title>Testowanie</title>
</head>
<body>
<div style="text-align: center;"><h2>Testowanie parametrów</h2></div>
<hr>
<div style="text-align: center;">
    <form method="get" action="http://localhost:8080/serwlety1/hello-servlet">
        <h3>AGE</h3>
        min <input type="text" size="5" name="age_min" value="0"> max <input type="text" size="5" name="age_max" value="100"><br>
        <br>
        <h3>Amount of Regional Trophies</h3>
        min <input type="text" size="5" name="regional_trophies_min" value="0"> max <input type="text" size="5" name="regional_trophies_max" value="100"><br>
        <br>
        <h3>Amount of International Trophies</h3>
        min <input type="text" size="5" name="international_trophies_min" value="0"> max <input type="text" size="5" name="international_trophies_max" value="100"><br>
        <br>
        <h3>Kraj:</h3>
        <input type="radio" id="Korea" name="region" value="kr" checked>
        <label for="Korea">South Korea</label><br>

        <input type="radio" id="Europe" name="region" value="eu">
        <label for="Europe">Europe</label><br>

        <input type="radio" id="China" name="region" value="cn">
        <label for="China">China</label><br>
        <br>
        <h3>Sortuj po:</h3>
        <input type="radio" id="Age" name="sort" value="age" checked>
        <label for="Age">Age</label>

        <input type="radio" id="InternationalTrophies" name="sort" value="international_trophies">
        <label for="InternationalTrophies">International Trophies</label>

        <input type="radio" id="RegionalTrophies" name="sort" value="regional_trophies">
        <label for="RegionalTrophies">Regional Trophies</label>
        <br><br>
        <input type="submit" value="Wyślij formularz">
    </form>
</div>
</body>
</html>