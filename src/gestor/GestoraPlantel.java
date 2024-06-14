package gestor;

import com.google.gson.*;
import plantelEnums.EProfesion;
import plantelPersonal.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestoraPlantel <T extends IntegrantePlantel>implements Serializable {
    private List<T>plantel;
    private static final Integer TOPE_FUTBOLISTAS=23;
    public GestoraPlantel(){
        plantel=new ArrayList<>();
    }
    private long contarFutbolistas(){return plantel.stream().filter(plantel-> plantel instanceof Futbolista).count();}
    private void agregarFutbolistaPrivado(T futbolista) throws RuntimeException{
        if(contarFutbolistas()<TOPE_FUTBOLISTAS)plantel.add(futbolista);
        else throw new RuntimeException("ya no hay lugar en la lista para mas futbolistas");
    }
    private boolean hayEntrenador(){return plantel.stream().anyMatch(plantel-> plantel instanceof Entrenador);}
    private void asginarEntrenadorPrivado(T entrenador)throws RuntimeException{
        if(!hayEntrenador())plantel.add(entrenador);
        else throw new RuntimeException("ya hay un entrenador asignado");
    }
    public void agregarIntegrante(T integrante){
        try {
            if(integrante instanceof Entrenador)asginarEntrenadorPrivado(integrante);
            else if (integrante instanceof Futbolista)agregarFutbolistaPrivado(integrante);
            else plantel.add(integrante);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    private void eleminarPrivado(T integrante)throws RuntimeException{
        if(!plantel.contains(integrante))throw new RuntimeException("El jugador no se encontro");
        else plantel.remove(integrante);
    }
    public void eleminarDelPLantel(T integrante){
        try {
            eleminarPrivado(integrante);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    public void listar(){plantel.forEach(System.out::println);}
    public List<T> getPlantel(){return plantel;}
    public void setPlantel(List<T> plantel){this.plantel = plantel;}
    public void guardarEnJson(){
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter("plantel"))){
            gson.toJson(plantel,bufferedWriter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void leerDesdeJson(){
        Gson gson=new Gson();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("plantel"))){
            JsonArray jsonArray= JsonParser.parseReader(bufferedReader).getAsJsonArray();
            plantel.clear();
            for(JsonElement jsonElement:jsonArray){
                JsonObject jsonObject=jsonElement.getAsJsonObject();
                EProfesion eProfesion=EProfesion.valueOf(jsonObject.get("eProfesion").getAsString());
                T integrante=null;
                if(eProfesion==EProfesion.AYUDANTEDECAMPO)integrante=gson.fromJson(jsonElement,(Type) AyudanteDeCampo.class);
                else if(eProfesion==EProfesion.ENTRENADOR)integrante=gson.fromJson(jsonElement,(Type) Entrenador.class);
                else if(eProfesion==EProfesion.FUTBOLISTA)integrante=gson.fromJson(jsonElement,(Type) Futbolista.class);
                else if(eProfesion==EProfesion.MASAJISTA)integrante=gson.fromJson(jsonElement,(Type) Masajista.class);
                else if(eProfesion==EProfesion.INTEGRANTE_PLANTEL)integrante=gson.fromJson(jsonElement,(Type) IntegrantePlantel.class);
                if(integrante!=null)plantel.add(integrante);
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void guardarEnTxt(){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("plantelTXT"))){
            oos.writeObject(plantel);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void leerDesdeTxt(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("plantelTXT"))){
            plantel=(List<T>) ois.readObject();
        }catch (FileNotFoundException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "GestoraPlantel{" +
                "plantel=" + plantel +
                '}';
    }
}
