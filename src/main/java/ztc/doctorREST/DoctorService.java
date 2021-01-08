package ztc.doctorREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repo;

    public List<Doctor> listAll() {
        return repo.findAll();
    }
    public void save(Doctor doctor){
        repo.save(doctor);
    }
    public Doctor get(Integer id) {
        return repo.findById(id).get();
    }
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
