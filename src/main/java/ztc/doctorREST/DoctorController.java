package ztc.doctorREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping("/doctors")
    public List<Doctor> list() {
        return service.listAll();
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Integer id) {
        try {
            Doctor doctor = service.get(id);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/doctors")
    public void add(@RequestBody Doctor doctor) {
        service.save(doctor);
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<Object> update(@RequestBody Doctor doctor,
                                         @PathVariable Integer id) {
        try {
            Doctor existDoctor = service.get(id);
            service.save(doctor);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
    @DeleteMapping("/doctors/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}

