package app.resources;

import app.entities.BaseModel;
import app.entities.Gender;
import app.entities.Patient;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONArray;

import org.*;

import java.util.Collections;
import java.util.List;
import java.*;
@RestController
@RequestMapping("/api/patients")
public class PatientsResource {

    public static class AgeAndGender {
        private int age;
        private Gender gender;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
    }

    @PostMapping("/{id}")
    public List<Patient> readAll(@PathVariable long id, @RequestBody AgeAndGender ageAndGender) {
        final Patient patient = new Patient();

        patient.setName("John Doe");
        patient.setAge(ageAndGender.getAge());
        patient.setGender(ageAndGender.getGender());
        patient.setId(id);

        return Collections.singletonList(patient);
    }

    @GetMapping("/{fullName}")
    public int readAll(@PathVariable String fullName) {
        JSONObject myJsonObject = new JSONObject();

        for (int i = 0; i < BaseModel.getPatients().size(); i++){
            if (BaseModel.getPatients().get(i).getName().equals(fullName)){

                return BaseModel.getPatients().get(i).getValue();
            }
        }

        return  0;
    }
}
