
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu
{
    private String[] opciones;
    public Menu(String[] ops){
        opciones = ops;
    }
    public String mostrarMenu(){
        String menu;
        menu = "  MENU DE OPCIONES \n" +
               "==================== \n";
        for(int i = 0 ; i < opciones.length ; i++){
            menu = menu + opciones[i] + "\n";
        }
        menu = menu + "==================== \n"+ 
                        "ELIGE UNA OPCION";
        return menu;
    }
}
