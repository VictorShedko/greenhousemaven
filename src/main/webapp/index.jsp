<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 17.12.2019
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="be_BY"/>
<fmt:bundle basename="page content">

    <html>
    <head>
        <title><fmt:message key="homepage.title"/></title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>
        <%--
        <div class="row justify-content-center">
            <div class="col-4">
                <h5>Спиок цветов оранжереи</h5>
            </div>
        </div>


        <div class="row justify-content-start">
            <div class="col-4">
                <div class="form-group">
                    <form name="Simple" action="greenhouseHome" method="POST">
                        <input type="hidden" name="type" value="parse"/>
                        <input type="submit" name="button" value="просмотреть оранжерею"/>
                        <div>
                            <input type="radio" id="contactChoice1"
                                   name="parserType" value="DOM">
                            <label for="contactChoice1">DOOM</label>

                            <input type="radio" id="contactChoice2"
                                   name="parserType" value="SAX">
                            <label for="contactChoice2">SAX</label>

                            <input type="radio" id="contactChoice3"
                                   name="parserType" value="StAX">
                            <label for="contactChoice3">StAX</label>
                        </div>


                    </form>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <div class="form-group">
                    <form method="POST" action="greenhouseHome/upload" enctype="multipart/form-data">
                        <input type="file" class="btn btn-default" name="file"/>
                        <p>
                            <button type="submit">загрузит файл</button>
                        </p>
                    </form>
                </div>

            </div>
        </div>





        <div class="form-group">
            <label><fmt:message key="homepage.parse.uploadfile.label"/></label>
            <form action="greenhouseHome/upload" method="POST" action="greenhouseHome/upload" enctype="multipart/form-data">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="customFile">
                    <label class="custom-file-label" for="customFile" ><fmt:message key="homepage.parse.uploadfile.fieldgtext"/></label>
                    <button type="submit" >загрузит файл</button>
                </div>
            </form>
        </div>
        --%>
    <div class="row">
        <div class="row justify-content-center">
            <div class="col">
                <h5><fmt:message key="homepage.welcomeText"/></h5>
            </div>
        </div>
    </div>
    <div class="row">

        <div class="col-4">
            <form action="greenhouseHome" method="POST">
                <div class="form-group">
                    <label><fmt:message key="homepage.parse.label"/></label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="parserType" id="DomRadio"
                               value="DOM" checked>
                        <label class="form-check-label" for="DomRadio">
                            <fmt:message key="homepage.parse.radiobutton.DOM"/>
                        </label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="parserType" id="StaxRadio"
                               value="StAX">
                        <label class="form-check-label" for="StaxRadio">
                            <fmt:message key="homepage.parse.radiobutton.StAX"/>
                        </label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="parserType" id="SaxRadio"
                               value="SAX">
                        <label class="form-check-label" for="SaxRadio">
                            <fmt:message key="homepage.parse.radiobutton.SAX"/>
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <input type="hidden" name="operation" value="show"/>
                    <button type="submit" class="btn btn-primary"><fmt:message
                            key="homepage.submit.button.text"/></button>
                </div>
            </form>
        </div>
    </div>
    <div class="row">

        <div class="col-4">
            <form method="POST" action="greenhouseHome" enctype="multipart/form-data">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <input type="hidden" name="operation" value="upload"/>
                        <button type="submit" class="btn btn-primary"><fmt:message
                                key="homepage.upload.button"/></button>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="file"/>
                        <label class="custom-file-label"><fmt:message
                                key="homepage.parse.uploadFile.fieldText"/></label>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <img src="images/belka.jpg" class="img-fluid" alt="Responsive image">
        </div>
    </div>
    </div>


    </body>
    </html>
</fmt:bundle>