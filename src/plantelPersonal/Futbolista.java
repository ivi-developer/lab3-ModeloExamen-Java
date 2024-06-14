package plantelPersonal;

import plantelEnums.EFutbolistaPosicion;
import plantelEnums.EProfesion;
import plantelInterfaces.IAccionesPlantel;
import plantelInterfaces.IJugarPartido;

import java.io.Serializable;

public class Futbolista extends IntegrantePlantel implements IJugarPartido, IAccionesPlantel, Serializable {
    private Integer numeroDeCamiseta;
    private plantelEnums.EFutbolistaPosicion EFutbolistaPosicion;
    public Futbolista(String nombre, String apellido, Integer edad, EProfesion eProfesion, Integer numeroDeCamiseta, EFutbolistaPosicion EFutbolistaPosicion) {
        super(nombre, apellido, edad,eProfesion);
        this.numeroDeCamiseta = numeroDeCamiseta;
        this.EFutbolistaPosicion = EFutbolistaPosicion;
    }
    @Override
    public void viajar(){}
    @Override
    public void concentrar(){}
    @Override
    public void jugarPartido(){}

    @Override
    public String toString() {
        return super.toString()+"Futbolista{" +
                "numeroDeCamiseta=" + numeroDeCamiseta +
                ", EFutbolistaPosicion=" + EFutbolistaPosicion +
                '}';
    }
}
