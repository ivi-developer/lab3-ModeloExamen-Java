package plantelPersonal;

import plantelEnums.EProfesion;

import java.io.Serializable;
import java.util.PropertyResourceBundle;

public class IntegrantePlantel implements Serializable {
    private String nombre;
    private String apellido;
    private Integer edad;
    private EProfesion eProfesion;
    public IntegrantePlantel(String nombre, String apellido, Integer edad, EProfesion eProfesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.eProfesion=eProfesion;
    }
    public IntegrantePlantel(){}
    @Override
    public String toString() {
        return "IntegrantePlantel{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
