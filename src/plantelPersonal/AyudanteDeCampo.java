package plantelPersonal;

import plantelEnums.EEntrenadorEstilo;
import plantelEnums.EProfesion;
import plantelInterfaces.IAccionesPlantel;
import plantelInterfaces.IJugarPartido;
import plantelInterfaces.IPrepararEnternamiento;

import java.io.Serializable;

public class AyudanteDeCampo extends IntegrantePlantel implements IJugarPartido, IPrepararEnternamiento, IAccionesPlantel, Serializable {
    private String metodologia;
    public AyudanteDeCampo(String nombre, String apellido, Integer edad, EProfesion eProfesion, String metodologia) {
        super(nombre, apellido, edad,eProfesion);
        this.metodologia = metodologia;
    }
    @Override
    public void viajar(){}
    @Override
    public void concentrar(){}
    @Override
    public void jugarPartido(){}
    @Override
    public void prepararEntrenamiento(){}
    @Override
    public String toString() {
        return super.toString()+"AyudanteDeCampo{" +
                "metodologia='" + metodologia + '\'' +
                '}';
    }
}
