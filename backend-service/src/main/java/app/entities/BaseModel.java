package app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private static ArrayList<Patient> patients = new ArrayList<Patient>();

    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public static void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
