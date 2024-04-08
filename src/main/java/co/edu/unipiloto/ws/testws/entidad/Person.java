/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.ws.testws.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author bairon
 */
@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullName", "age"})
public class Person {

    private int id;
    private String fullName;
    private int age;
    private double salary;

    private static final double SALARIO_MINIMO = 1000.00;

    public Person() {

    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public double getSalary() {
        return salary;
    }

    private double calculateSalary(int age) {
        return age * SALARIO_MINIMO / 3;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.salary = calculateSalary(age);
    }
}
