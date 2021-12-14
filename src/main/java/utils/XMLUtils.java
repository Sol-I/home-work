package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class XMLUtils {
    public static Request XMLtoRequest(String s) throws JsonProcessingException {
        return new XmlMapper().readValue(s, Request.class);
    }

    public static Response XMLtoResponse(String s) throws JsonProcessingException {
        return new XmlMapper().readValue(s, Response.class);
    }

    public static String toXML(Request request) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(request);
    }

    public static String toXML(Response response) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(response);
    }
}
