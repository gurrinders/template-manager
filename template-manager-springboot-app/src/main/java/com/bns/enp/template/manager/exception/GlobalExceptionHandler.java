package com.bns.enp.template.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        String s = "#set($genericTemplate = ${headers.HDR_GENERIC_TEMPLATE_CONTENT})\n" +
                "#set($profile = ${headers.HDR_PROFILE_KEY}) \n" +
                "#set($first = $profile.get(\"name\").get(\"first\")) \n" +
                "#set($salutation = ${headers.HDR_SALUTATION})\n" +
                "#set($line = ${headers.HDR_Line1})\n" +
                "#set ()\n" +
                "\n" +
                "#if ($first)\n" +
                "\t#set($customerName = $first)\n" +
                "#else\n" +
                "\t#set($customerName = \"\")\n" +
                "#end\n" +
                "#set($innerTitle = $line1)\n" +
                "#set($emailText = \"<p>$body</p>\n" +
                "                   <p>At your earliest convenience, please confirm and/or update your information by:</p>\n" +
                "\t\t    \t\t<ul>\t\t\t   \n" +
                "\t\t\t\t\t<li>Speaking to a representative in any branch</li>\n" +
                "\t\t\t\t\t<li>Calling our contact centre 24/7</li>\n" +
                "\t\t        \t<ul>\n" +
                "                       <li>1-800-4-SCOTIA (1-800-472-6842)</li>\n" +
                "\t\t        \t   <li>1-800-645-0288 (Services for deaf, deafened or hard of hearing)</li>\n" +
                "                    </ul>\n" +
                "\t\t        \t<li>If you have Scotia OnLine, log in to your Scotia OnLine account</li></ul>\n" +
                "\t\t            <p>If you have any questions, please contact us.</p>\")\n" +
                "#evaluate($genericTemplate)";
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}