package minera.server.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import minera.server.model.Vehiculo;
import minera.server.service.VehiculoService;

@RestController
@RequestMapping(path = "/vehiculos")
public class VehiculosController {
    @Autowired
    private VehiculoService svc;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Vehiculo>> fetch() {

        List<Vehiculo> rows = svc.find();
        return new ResponseEntity<List<Vehiculo>>(rows, HttpStatus.OK);
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
    public ResponseEntity fetchById(@PathVariable("id") Integer id) throws Exception {

        Vehiculo r = svc.findFirstById(id);
        HttpStatus status = HttpStatus.NOT_FOUND;
        if (r != null) {
            return new ResponseEntity<Vehiculo>(r, HttpStatus.OK);
        }

        HashMap<String, Boolean> response = new HashMap<>();
        response.put("ok", false);
        return new ResponseEntity<HashMap<String, Boolean>>(response, status);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, Integer>> create(@RequestBody Vehiculo r) throws Exception {
        Integer rowId = svc.create(r);

        HashMap<String, Integer> response = new HashMap<>();
        response.put("id", rowId);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (rowId > 0) {
            status = HttpStatus.CREATED;
        }

        return new ResponseEntity<HashMap<String, Integer>>(response, status);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<HashMap<String, Integer>> update(@RequestBody Vehiculo r) throws Exception {

        HashMap<String, Integer> response = new HashMap<>();

        if (svc.findFirstById(r.idVehiculo) == null) {
            response.put("id", 0);
            return new ResponseEntity<HashMap<String, Integer>>(response, HttpStatus.NOT_FOUND);
        }

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (svc.update(r)) {
            response.put("id", r.idVehiculo);
            status = HttpStatus.OK;
        }

        return new ResponseEntity<HashMap<String, Integer>>(response, status);
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws Exception {

        Vehiculo r = svc.findFirstById(id);
        HashMap<String, Boolean> response = new HashMap<>();

        if (r == null || !svc.delete(id)) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            response.put("ok", false);
            return new ResponseEntity<HashMap<String, Boolean>>(response, status);
        }

        HttpStatus status = HttpStatus.OK;
        response.put("ok", true);
        return new ResponseEntity<HashMap<String, Boolean>>(response, status);
    }
}
