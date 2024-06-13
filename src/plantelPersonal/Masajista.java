package plantelPersonal;

import plantelEnums.EProfesion;
import plantelInterfaces.IAccionesPlantel;
import plantelInterfaces.IDarAsistencia;

public class Masajista extends IntegrantePlantel implements IDarAsistencia, IAccionesPlantel {
    private String titulo;
    private Integer aniosDeExperiencia;
    public Masajista(String nombre, String apellido, Integer edad, EProfesion eProfesion, String titulo, Integer aniosDeExperiencia) {
        super(nombre, apellido, edad,eProfesion);
        this.titulo = titulo;
        this.aniosDeExperiencia = aniosDeExperiencia;
    }
    @Override
    public void viajar(){}
    @Override
    public void concentrar(){}
    @Override
    public void darAsistencia(){}
    @Override
    public String toString() {
        return  super.toString()+"Masajista{" +
                "titulo='" + titulo + '\'' +
                ", aniosDeExperiencia=" + aniosDeExperiencia +
                '}';
    }
}
