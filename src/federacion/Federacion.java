package federacion;

import gestor.GestoraPlantel;
import plantelPersonal.IntegrantePlantel;

public class Federacion {
    private String nombre;
    private String fechaDeFundacion;
    private Integer cantCopasMundiales;
    private GestoraPlantel<IntegrantePlantel> gestoraPlantel;

    public Federacion(String nombre, String fechaDeFundacion, Integer cantCopasMundiales) {
        this.nombre = nombre;
        this.fechaDeFundacion = fechaDeFundacion;
        this.cantCopasMundiales = cantCopasMundiales;
        gestoraPlantel = new GestoraPlantel<>();
    }
    public void agregarAlPlantel(IntegrantePlantel integrantePlantel){gestoraPlantel.agregarIntegrante(integrantePlantel);}
    public void eliminarDelPLantel(IntegrantePlantel integrantePlantel){gestoraPlantel.eleminarDelPLantel(integrantePlantel);}
    public void mostrarPlantel(){gestoraPlantel.listar();}
    public void guardarEnJson(){gestoraPlantel.guardarEnJson();}
    public void leerDeJson(){gestoraPlantel.leerDesdeJson();}
    public void guardarEnTxt(){gestoraPlantel.guardarEnTxt();}
    public void leerDeTxt(){gestoraPlantel.leerDesdeTxt();}
}