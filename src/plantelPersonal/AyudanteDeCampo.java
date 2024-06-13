package plantelPersonal;

import plantelEnums.EProfesion;
import plantelInterfaces.IAccionesPlantel;
import plantelInterfaces.IJugarPartido;
import plantelInterfaces.IPrepararEnternamiento;

public class AyudanteDeCampo extends IntegrantePlantel implements IJugarPartido, IPrepararEnternamiento, IAccionesPlantel {
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
