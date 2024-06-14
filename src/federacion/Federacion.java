package federacion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import gestor.GestoraPlantel;
import plantelPersonal.IntegrantePlantel;

import java.io.*;

public class Federacion implements Serializable{
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
    public Federacion(){}
    public void agregarAlPlantel(IntegrantePlantel integrantePlantel){gestoraPlantel.agregarIntegrante(integrantePlantel);}
    public void eliminarDelPLantel(IntegrantePlantel integrantePlantel){gestoraPlantel.eleminarDelPLantel(integrantePlantel);}
    public void mostrarPlantel(){gestoraPlantel.listar();}
    public void guardarEnJson(){gestoraPlantel.guardarEnJson();}
    public void guardarFederacionEnJson(){
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("federacionAJson"))){
            gson.toJson(this,bufferedWriter);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Federacion leerFederacionDeJson(){
        Gson gson=new Gson();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("federacionAJson"))){
            return gson.fromJson(bufferedReader,new TypeToken<Federacion>(){}.getType());
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
        return new Federacion();
    }
    public void guardarFederacionTxt(){
        try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("federacionATxt"))){
            objectOutputStream.writeObject(this);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Federacion leerFederacionTxt(){
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("federacionATxt"))){
            return (Federacion) objectInputStream.readObject();
        }catch(FileNotFoundException |ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
        return new Federacion();
    }
    public void leerDeJson(){gestoraPlantel.leerDesdeJson();}
    public void guardarEnTxt(){gestoraPlantel.guardarEnTxt();}
    public void leerDeTxt(){gestoraPlantel.leerDesdeTxt();}
    @Override
    public String toString() {
        return "Federacion{" +
                "nombre='" + nombre + '\'' +
                ", fechaDeFundacion='" + fechaDeFundacion + '\'' +
                ", cantCopasMundiales=" + cantCopasMundiales +
                ", gestoraPlantel=" + gestoraPlantel +
                '}';
    }
}