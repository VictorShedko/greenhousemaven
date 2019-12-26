package by.victor.greenhouse.servlet;

import by.victor.greenhouse.action.FlowerDataAction;
import by.victor.greenhouse.builder.*;
import by.victor.greenhouse.entity.FlowerData;
import by.victor.greenhouse.entity.Plant;
import by.victor.greenhouse.filemanager.GreenhouseFileManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@WebServlet("/greenhouseHome")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)


public class GreenhouseServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(GreenhouseServlet.class);
    private static final String uploadFilePath = "C:\\temp";

    private static final String OPERATION_PARAMETER="operation";
    private static final String PARSE_TYPE_PARAMETER="parserType";
    private static final String FILE_NOT_FOUND_MESSAGE="operation";
    private static final String RESULT_LIST_ATTRIBUTE ="resultList";
    private static final String UPLOAD_RESULT_ATTRIBUTE ="upload_result";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestType = request.getParameter(OPERATION_PARAMETER);
        switch (requestType) {
            case "show":
                greenhouseShowRequest(request, response);
                break;
            case "upload":
                uploadFile(request, response);
                break;
        }

    }


    protected void greenhouseShowRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("parse ");

        if (GreenhouseFileManager.getFileToParse().isPresent() && request.getParameter(PARSE_TYPE_PARAMETER) != null) {
            Director director = new Director();
            Set<Plant> plants;
            switch (request.getParameter(PARSE_TYPE_PARAMETER)) {
                case "DOM":
                    director.parsePlants(ParseType.DOM);
                    break;
                case "StAX":
                    director.parsePlants(ParseType.STAX);
                    break;
                case "SAX":
                    director.parsePlants(ParseType.SAX);
                    break;
                default: {
                    logger.error("no such a parse type");
                    director.parsePlants(ParseType.DOM);
                    break;
                }

            }
            if (director.getPlants().isPresent()) {
                plants = director.getPlants().get();
                FlowerDataAction action = new FlowerDataAction();
                List<FlowerData> displayList = plants.stream().map(action::toFlowerData).collect(Collectors.toList());
                request.setAttribute(RESULT_LIST_ATTRIBUTE, displayList);
                request.getRequestDispatcher(PagePath.PLANTS_PAGE).forward(request, response);
            } else {
                logger.error("parse error");
                request.getRequestDispatcher(PagePath.ERROR_PAGE).forward(request, response);
            }


        } else {
            logger.error("file was not upload");
            request.getRequestDispatcher(PagePath.ERROR_PAGE).forward(request, response);
        }

    }

    protected void uploadFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParts().isEmpty()) {
            request.setAttribute(UPLOAD_RESULT_ATTRIBUTE, " file wasnt select");
        }
        request.getParts().forEach(part -> {
            File downloadedFile;
            try {
                if (part.getSubmittedFileName() != "null") {
                    part.write(uploadFilePath + File.separator + part.getSubmittedFileName());//.substring(2)
                    request.setAttribute(UPLOAD_RESULT_ATTRIBUTE, " upload successfully ");
                    downloadedFile = new File(uploadFilePath + File.separator + part.getSubmittedFileName());
                    GreenhouseFileManager.setFileToParse(downloadedFile);
                } else {
                    request.setAttribute(UPLOAD_RESULT_ATTRIBUTE, " upload failed ");
                }
            } catch (IOException e) {
                request.setAttribute(UPLOAD_RESULT_ATTRIBUTE, " upload failed ");
            }
        });
        request.getRequestDispatcher(PagePath.UPLOAD_PAGE).forward(request, response);


    }
}


