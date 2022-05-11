package minera.server.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import minera.server.model.Posicion;
import minera.server.model.Vehiculo;
import minera.server.service.PosicionService;
import minera.server.service.VehiculoService;

@RestController
@CrossOrigin
@RequestMapping(path = "/posiciones")
public class PosicionesController {
    @Autowired
    private PosicionService svc;
    @Autowired
    private VehiculoService vehiculoSvc;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Posicion>> fetch() {

        List<Posicion> rows = svc.find();
        return new ResponseEntity<List<Posicion>>(rows, HttpStatus.OK);
    }

    @RequestMapping(value = { "/{matricula}" }, method = RequestMethod.GET)
    public ResponseEntity create(@PathVariable("matricula") String matricula)
            throws Exception {

        List<Posicion> posiciones = new ArrayList<>();
        Vehiculo v = vehiculoSvc.findFirstByMatricula(matricula);
        if (v == null) {
            return new ResponseEntity<List<Posicion>>(posiciones, HttpStatus.NOT_FOUND);
        }

        posiciones = svc.findByVehiculo(v);
        return new ResponseEntity<List<Posicion>>(posiciones, HttpStatus.OK);
    }

    @RequestMapping(value = { "/{matricula}" }, method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable("matricula") String matricula, @RequestBody Posicion p)
            throws Exception {

        HashMap<String, Boolean> response = new HashMap<>();
        Vehiculo v = vehiculoSvc.findFirstByMatricula(matricula);
        if (v == null) {
            response.put("ok", false);
            return new ResponseEntity<Posicion>(HttpStatus.NOT_FOUND);
        }

        p.idVehiculo = v.idVehiculo;
        p.timeAt = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        Integer posicionId = svc.create(p);
        if (posicionId <= 0) {
            response.put("ok", false);
            return new ResponseEntity<HashMap<String, Boolean>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("ok", true);
        return new ResponseEntity<HashMap<String, Boolean>>(response, HttpStatus.CREATED);
    }

}
