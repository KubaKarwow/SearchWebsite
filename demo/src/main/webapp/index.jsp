<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
    <title>Testowanie</title>
</head>
<body>
<div style="text-align: center;"><h2>Get records with:</h2></div>
<hr>
<div style="text-align: center;">
    <form method="get" action="http://localhost:8080/demo_war_exploded/hello-servlet">
        <h3>AGE</h3>
        min <input type="text" size="5" name="age_min" value="0"> max <input type="text" size="5" name="age_max" value="100"><br>
        <br>
        <h3>Amount of Regional Trophies</h3>
        min <input type="text" size="5" name="regional_trophies_min" value="0"> max <input type="text" size="5" name="regional_trophies_max" value="100"><br>
        <br>
        <h3>Amount of International Trophies</h3>
        min <input type="text" size="5" name="international_trophies_min" value="0"> max <input type="text" size="5" name="international_trophies_max" value="100"><br>
        <br>
        <h3>Region:</h3>
        <input type="radio" id="Korea" name="region" value="South Korea" checked>
        <label for="Korea">South Korea</label><br>

        <input type="radio" id="Europe" name="region" value="Europe">
        <label for="Europe">Europe</label><br>

        <input type="radio" id="China" name="region" value="China">
        <label for="China">China</label><br>
        <br>
        <h3>Sort by:</h3>
        <input type="radio" id="Age" name="sort" value="AGE" checked>
        <label for="Age">Age</label>

        <input type="radio" id="InternationalTrophies" name="sort" value="INTERNATIONALWINS">
        <label for="InternationalTrophies">International Trophies</label>

        <input type="radio" id="RegionalTrophies" name="sort" value="REGIONALWINS">
        <label for="RegionalTrophies">Regional Trophies</label>
        <br><br>
        <input type="submit" value="Wyślij formularz">
    </form>
</div>
</body>
</html>