import java.util.Scanner;
public class Programa
{
    public static void main(String args[]){
        Menu menu;
        int opcion;
        Scanner input = new Scanner(System.in);
        Juego1024 j = new Juego1024();
        menu = new Menu(new String[]{"1 Inicializar",  
                                     "2 Mover", 
                                     "3 Salir"});
        do{
            System.out.println(menu.mostrarMenu());
            opcion = Integer.parseInt(input.nextLine());
            switch(opcion){
                case 1 : System.out.println(j.inicializar()); break; 
                
                case 2 : if(!j.getInicializado()){ 
                             System.out.println("PRIMERO DEBES INICIALIZAR EL JUEGO \n");
                         }else{
                             System.out.println("Ingrese la direccion (w,a,s,d)"); 
                             System.out.println(j.mover(input.nextLine().charAt(0))); 
                         }
                         break; 
            }
        }while(opcion != 3);    
    }
}
