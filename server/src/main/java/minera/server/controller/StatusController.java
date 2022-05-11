package minera.server.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/status")
public class StatusController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Boolean>> status() {
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("ok", true);
        return new ResponseEntity<HashMap<String, Boolean>>(response, HttpStatus.OK);
    }

}
