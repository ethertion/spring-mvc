<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body>
        <h1>Spring MVC Hello World Example</h1>
        <h2>${msg}</h2>
        <form action="post" method="POST">
            Post your hello: <input type="text" name="hello">
            <input type="submit" value="Submit"/>
        </form>

    </body>
</html>