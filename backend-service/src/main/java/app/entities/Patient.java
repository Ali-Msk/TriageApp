package app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends BaseModel {
    private String name;
    private int age;
    private Gender gender;
    private String medCondition;
    private String previousCondition;
    private int pregnancy;
    private int value;
    private int medConditionValue;


    /**
     * constructor for patient that takes in all values for the patient at once
     * //@param String name, medCondition and previous condition, and int age, pregnancy period, medConValue
     */
    public Patient(String name, int age, Gender gender, String medCondition,
                   int medConditionValue, String previousCondition, int pregnancy){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medCondition = medCondition;
        this.medConditionValue  = medConditionValue;
        this.previousCondition = previousCondition;
        this.pregnancy = pregnancy;
        this.value = this.valueAssigner();
    }

    //constructor with no parameter
    public Patient(){}

    public int valueAssigner(){
        int ageValue = 0;
        if (this.age < 6 || this.age < 59){
            ageValue += 2;
        }else if(this.age < 60 && this.age > 16){
            ageValue += 0;
        }else{
            ageValue ++;
        }

        int pregnancyValue = 0;
        if (this.pregnancy > 9){
            pregnancyValue += 9;
        }else{
            pregnancyValue += this.pregnancy;
        }

        return this.medConditionValue * 100 + ageValue + pregnancyValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getMedCondition() {
        return medCondition;
    }

    public void setMedCondition(String medCondition) {
        this.medCondition = medCondition;
    }

    public String getPreviousCondition() {
        return previousCondition;
    }

    public void setPreviousCondition(String previousCondition) {
        this.previousCondition = previousCondition;
    }

    public int getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(int pregnancy) {
        this.pregnancy = pregnancy;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMedConditionValue() {
        return medConditionValue;
    }

    public void setMedConditionValue(int medConditionValue) {
        this.medConditionValue = medConditionValue;
    }
}
