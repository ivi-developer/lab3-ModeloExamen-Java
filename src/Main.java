import federacion.Federacion;
import plantelEnums.EEntrenadorEstilo;
import plantelEnums.EEntrenadorSiestemaDeJuego;
import plantelEnums.EFutbolistaPosicion;
import plantelEnums.EProfesion;
import plantelPersonal.AyudanteDeCampo;
import plantelPersonal.Entrenador;
import plantelPersonal.Futbolista;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        Federacion federacion=new Federacion("AFA","25/05/1810",3);
        try {
            do{
                System.out.println("numero pibe");
                switch (scanner.nextInt()){
                    case 1:
                        federacion.agregarAlPlantel(new Futbolista("Lionel","Messi",34, EProfesion.FUTBOLISTA,10, EFutbolistaPosicion.DELANTERO));
                        federacion.agregarAlPlantel(new Futbolista("Emiliano", "Martinez",30,EProfesion.FUTBOLISTA,23,EFutbolistaPosicion.ARQUERO));
                        for(int i=0;i<23;i++){
                            federacion.agregarAlPlantel(new Futbolista("Emiliano", "Martinez",30,EProfesion.FUTBOLISTA,23,EFutbolistaPosicion.ARQUERO));
                        }
                        federacion.agregarAlPlantel(new Entrenador("Lionel","Scaloni",48,EProfesion.ENTRENADOR ,EEntrenadorSiestemaDeJuego.SISTEMA_433, EEntrenadorEstilo.POSESION));
                        federacion.agregarAlPlantel(new Entrenador("Lionel","Scaloni",48, EProfesion.ENTRENADOR,EEntrenadorSiestemaDeJuego.SISTEMA_433, EEntrenadorEstilo.POSESION));
                        federacion.agregarAlPlantel(new AyudanteDeCampo("Pablo","Aimar",49,EProfesion.AYUDANTEDECAMPO,"Magia"));
                        break;
                    case 2:
                        federacion.guardarEnJson();
                        break;
                    case 3:
                        federacion.leerDeJson();
                        break;
                    case 4:
                        federacion.mostrarPlantel();
                        break;
                }
                System.out.println("n para cortar");
            }while(!scanner.next().equalsIgnoreCase("n"));
        }catch (InputMismatchException e){
            e.printStackTrace();
        }
    }
}