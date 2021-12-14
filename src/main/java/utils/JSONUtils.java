package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class JSONUtils {

    public static Request JSONtoRequest(String s) throws JsonProcessingException {
        return new ObjectMapper().readValue(s, Request.class);
    }

    public static Response JSONtoResponse(String s) throws JsonProcessingException {
        return new ObjectMapper().readValue(s, Response.class);
    }

    public static String toJSON(Request request) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(request);
    }

    public static String toJSON(Response response) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(response);
    }

}
