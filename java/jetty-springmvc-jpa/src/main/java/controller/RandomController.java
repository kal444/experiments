package controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping({"/random"})
public class RandomController {

    private static final String ALGORITHM = "SHA1PRNG";

    /**
     * Produces only JSON output. If client specifies restrictive accept header, then it will fail
     *
     * @param req
     * @param res
     *
     * @return
     */
    @RequestMapping(value = {"/double"}, method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object getRandomDouble(HttpServletRequest req, HttpServletResponse res) {
        return ImmutableMap.of(Double.class.getSimpleName(), rngInstance().nextDouble());
    }

    /**
     * Produces only plain text output. If the client specifies json in accept header or using the .json extension, then it will fail
     *
     * @param req
     * @param res
     *
     * @return
     */
    @RequestMapping(value = {"/string"}, method = {RequestMethod.GET}, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getRandomString(HttpServletRequest req, HttpServletResponse res) {
        return "I AM A RANDOM STRING! NO REALLY!";
    }

    private static SecureRandom rngInstance() {
        try {
            return SecureRandom.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
