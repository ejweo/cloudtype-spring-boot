package io.cloudtype.waitlist.controller;

import io.cloudtype.waitlist.exception.ResourceNotFoundException;
import io.cloudtype.waitlist.model.Career;
import io.cloudtype.waitlist.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/career")
public class CareerController {

    @Autowired
    private CareerRepository careerRepository;

    @GetMapping
    public List<Career> getAllCareer() {
        return careerRepository.findAll();
    }

    @PostMapping
    public Career createCareer(@RequestBody Career career) {
        return careerRepository.save(career);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Career> getCareerById(@PathVariable Long id) {
        Career career  = careerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Career not found."));
        return ResponseEntity.ok(career);
    }

    @PutMapping("{id}")
    public ResponseEntity<Career> updateCareer(@PathVariable Long id, @RequestBody Career careerInfo) {
        Career updateCareer = careerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Career not found."));
        updateCareer.setName(careerInfo.getName());
        updateCareer.setNum(careerInfo.getNum());

        careerRepository.save(updateCareer);

        return ResponseEntity.ok(updateCareer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCareer(@PathVariable Long id) {

        Career career = careerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Career not found."));

        careerRepository.delete(career);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
