package plantelPersonal;

import plantelEnums.EEntrenadorEstilo;
import plantelEnums.EEntrenadorSiestemaDeJuego;
import plantelEnums.EProfesion;
import plantelInterfaces.IAccionesPlantel;
import plantelInterfaces.IJugarPartido;
import plantelInterfaces.IPrepararEnternamiento;

public class Entrenador extends IntegrantePlantel implements IJugarPartido, IPrepararEnternamiento, IAccionesPlantel {
    private EEntrenadorSiestemaDeJuego eEntrenadorSiestemaDeJuego;
    private EEntrenadorEstilo eEntrenadorEstilo;
    public Entrenador(String nombre, String apellido, Integer edad, EProfesion eProfesion, EEntrenadorSiestemaDeJuego eEntrenadorSiestemaDeJuego, EEntrenadorEstilo eEntrenadorEstilo) {
        super(nombre, apellido, edad,eProfesion);
        this.eEntrenadorSiestemaDeJuego = eEntrenadorSiestemaDeJuego;
        this.eEntrenadorEstilo = eEntrenadorEstilo;
    }
    public Entrenador(){super();}
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
        return super.toString()+"Entrenador{" +
                "eEntrenadorSiestemaDeJuego=" + eEntrenadorSiestemaDeJuego +
                ", eEntrenadorEstilo=" + eEntrenadorEstilo +
                '}';
    }
}
