<html lang="en">
<head>
    <title>Menu</title>
</head>
<body>
<h1>Our delicious menu</h1>
<#--

FreeMarker provides a simple specialized language called
FTL (FreeMarker Template Language)
that is used to create templates
comments will be ignored in the output

the file name should have the .ftlh extension.

interpolation use ${pizza.price}

-->

<h3><a href="https://freemarker.apache.org/docs/index.html" target="_blank">freemarker</a></h3>
<table>
    <tr>
        <th>Pizza</th>
        <th>Price (USD)</th>
    </tr>
    <#list pizzas as pizza>
        <tr>
            <td>${pizza.name}</td>
            <td>${pizza.price}</td>
        </tr>
    </#list>
</table>
</body>
</html>