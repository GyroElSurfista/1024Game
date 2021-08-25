public class Juego1024
{
    private Celda[][] tablero;
    private boolean ganado;
    private boolean iniciado;
    public Juego1024(){
        tablero = new Celda[4][4];
        iniciarTablero();
    }
    public String inicializar(){
        String reporte;
        resetTablero();
        generarRandom();
        generarRandom();
        iniciado = true;
        reporte = "Juego incializado" + "\n" + mostrar();
        return reporte;
    }
    public void ponerNumero(int num, int posi, int posj){
        tablero[posi][posj].setValor(num);
        tablero[posi][posj].setOcupada(true);
    }
    public String mover(char movimiento){
        String resultado = "";
        if(perdio()){
            resultado = "PERDISTE"; 
        }else if(iniciado){
            switch(movimiento){
                case 'w':
                moverArriba();
                generarRandom();
                break;
                case 's':
                moverAbajo();
                generarRandom();
                break;
                
                case 'a':
                moverIzquierda();
                generarRandom();
                break;
                case 'd':
                moverDerecha();
                generarRandom();
                break;
            }
            resultado = mostrar();
            if(ganaste()){
                resultado = resultado + "\n" +"\n"+"GANASTE!!!";
                iniciado = false;
            }
        }else{
            resultado = "PRIMERO DEBES INICIALIZAR EL JUEGO";
        }
        return resultado;
    }
    private void moverAbajo(){
        for(int j =0  ; j < tablero.length ; j++ ){
            for(int i = tablero.length - 2 ; i >= 0 ; i--){
                if(tablero[i][j].getValor() == 0){
                
                }else{
                    int ind = i;
                    while(ind < tablero.length - 1 ){
                        if(tablero[ind + 1][j].getValor() != 0){
                            if(tablero[i][j].getValor() == tablero[ind + 1][j].getValor() && !tablero[ind + 1][j].getSumada()){
                                tablero[ind + 1][j].setValor(tablero[ind + 1][j].getValor() +tablero[i][j].getValor()); 
                                tablero[ind + 1][j].setOcupada(true);
                                tablero[ind + 1][j].setSumada(true);
                                tablero[i][j].setValor(0);
                                tablero[i][j].setOcupada(false);
                            }else{
                                if(i != ind && tablero[i][j].getValor() != 0){
                                    tablero[ind][j].setValor(tablero[i][j].getValor());
                                    tablero[ind][j].setOcupada(true);
                                    tablero[i][j].setValor(0);
                                    tablero[i][j].setOcupada(false);
                                    ind = tablero.length - 1;
                                }else{
                                    ind = tablero.length - 1;
                                }
                            }
                        }else if(ind + 1 == (tablero.length - 1)){
                            tablero[ind + 1][j].setValor(tablero[i][j].getValor());
                            tablero[ind + 1][j].setOcupada(true);
                            tablero[i][j].setValor(0);
                            tablero[i][j].setOcupada(false);
                        }
                        ind++;
                    }
                }
            }
        }  
        resetSumas();
    }
    private void moverArriba(){
        for(int j = 0; j < tablero.length ; j++){
            for(int i = 1 ; i < tablero.length ; i++){
                if(tablero[i][j].getValor() == 0){
                    
                }else{
                    int ind = i;
                    while(ind > 0  ){
                        if(tablero[ind - 1][j].getValor() != 0){
                            if(tablero[i][j].getValor() == tablero[ind - 1][j].getValor() && !tablero[ind - 1][j].getSumada()){
                                tablero[ind - 1][j].setValor(tablero[ind - 1][j].getValor() + tablero[i][j].getValor());
                                tablero[ind - 1][j].setOcupada(true);
                                tablero[ind - 1][j].setSumada(true);
                                tablero[i][j].setValor(0);
                                tablero[i][j].setOcupada(false);
                            }else{
                                if(i != ind && tablero[i][j].getValor() != 0){
                                    tablero[ind][j].setValor(tablero[i][j].getValor());
                                    tablero[ind][j].setOcupada(true);
                                    tablero[i][j].setValor(0);
                                    tablero[i][j].setOcupada(false);
                                    ind = 0;
                                }else{
                                    ind = 0;
                                }
                            }
                        }else if(ind - 1 == 0){
                            tablero[ind - 1][j].setValor(tablero[i][j].getValor());
                            tablero[ind - 1][j].setOcupada(true);
                            tablero[i][j].setValor(0);
                            tablero[i][j].setOcupada(false);
                        }
                        ind--;
                    }                
                }
            }
        }
        resetSumas();
    }
    private void moverIzquierda(){   
        for(int i = 0 ; i < tablero.length ; i++){
            for(int j = 1 ; j < tablero.length ; j++){
                if(tablero[i][j].getValor() == 0){
                    
                }else{
                    int ind = j;
                    while(ind > 0 ){
                        if(tablero[i][ind - 1].getValor() != 0){
                            if(tablero[i][j].getValor() == tablero[i][ind - 1].getValor() && !tablero[i][ind - 1].getSumada()){
                                tablero[i][ind - 1].setValor(tablero[i][ind - 1].getValor() + tablero[i][j].getValor()) ;
                                tablero[i][ind - 1].setOcupada(true);
                                tablero[i][ind - 1].setSumada(true);
                                tablero[i][j].setValor(0);
                                tablero[i][j].setOcupada(false);
                            }else{
                                if(j != ind && tablero[i][j].getValor() != 0){
                                    tablero[i][ind].setValor(tablero[i][j].getValor());
                                    tablero[i][ind].setOcupada(true);
                                    tablero[i][j].setValor(0);
                                    tablero[i][j].setOcupada(false);
                                    ind = 0;
                                }else{
                                    ind = 0;
                                }
                            }
                        }else if(ind - 1 == 0){
                            tablero[i][ind - 1].setValor(tablero[i][j].getValor());
                            tablero[i][ind - 1].setOcupada(true);
                            tablero[i][j].setValor(0);
                            tablero[i][j].setOcupada(false);
                        }
                        ind--;
                    }                
                }
            }
        }
        resetSumas();
    }
    private void moverDerecha(){
        for(int i = 0  ; i < tablero.length ; i++ ){
            for(int j = tablero.length - 2 ; j >= 0 ; j--){
                if(tablero[i][j].getValor() == 0){
                
                }else{
                    int ind = j;
                    while(ind < tablero.length - 1 ){
                        if(tablero[i][ind + 1].getValor() != 0){
                            if(tablero[i][j].getValor() == tablero[i][ind + 1].getValor() && !tablero[i][ind + 1].getSumada()){
                                tablero[i][ind + 1].setValor(tablero[i][ind + 1].getValor() + tablero[i][j].getValor()); 
                                tablero[i][ind + 1].setOcupada(true);
                                tablero[i][ind + 1].setSumada(true);
                                tablero[i][j].setValor(0);
                                tablero[i][j].setOcupada(false);
                            }else{
                                if(j != ind && tablero[i][j].getValor() != 0){
                                    tablero[i][ind].setValor(tablero[i][j].getValor());
                                    tablero[i][ind].setOcupada(true);
                                    tablero[i][j].setValor(0);
                                    tablero[i][j].setOcupada(false);
                                    ind = tablero.length - 1;
                                }else{
                                    ind = tablero.length - 1;
                                }
                            }
                        }else if(ind + 1 == (tablero.length - 1)){
                            tablero[i][ind + 1].setValor(tablero[i][j].getValor());
                            tablero[i][ind + 1].setOcupada(true);
                            tablero[i][j].setValor(0);
                            tablero[i][j].setOcupada(false);
                        }
                        ind++;
                    }
                }
            }
        }   
        resetSumas();
    }
    private void generarRandom(){
        boolean generado = false;
        int i = (int)(Math.random() * tablero.length);
        int j = (int)(Math.random() * tablero.length);
        int r = (int)(Math.random() * 3);
        while(r == 0){
            r = (int)(Math.random() * 3);
        }
        while(!generado && !todasOcupadas()){
            if(tablero[i][j].getOcupada()){
                i = (int)(Math.random() * tablero.length);
                j = (int)(Math.random() * tablero.length);
            }else{
                tablero[i][j].setValor(r);
                tablero[i][j].setOcupada(true);
                generado = true;
            }            
        }
    }
    public String mostrar(){
        String muestra = "";
        for(int i = 0 ;i < tablero.length ; i++){
            for(int j = 0 ; j < tablero[0].length ; j++){
                if(tablero[i][j].getValor() < 10){
                  muestra = muestra + "   " + tablero[i][j].getValor() + " ";
                }else if(tablero[i][j].getValor() >= 10 && tablero[i][j].getValor() < 100){
                    muestra = muestra +"  " + tablero[i][j].getValor() + " ";
                }else if(tablero[i][j].getValor() >= 100 && tablero[i][j].getValor() < 1000){
                    muestra = muestra +" " + tablero[i][j].getValor() + " ";
                }else{
                    muestra = muestra + tablero[i][j].getValor() + " ";
                }
            }
            muestra = muestra + "\n";
        }
        return muestra;
    }
    private void resetTablero(){
        for(int i = 0 ; i < tablero.length ; i++){
            for(int j = 0; j < tablero.length ; j++){
                tablero[i][j].setValor(0);
                tablero[i][j].setOcupada(false);
                tablero[i][j].setSumada(false);
            }
        }
    }
    private boolean ganaste(){
        boolean gano = false;
        int i = 0;
        int j = 0;
        while(i < tablero.length && !gano){
            j = 0;
            while(j < tablero.length && !gano){
                if(tablero[i][j].getValor() == 1024){
                    gano = true;
                }
                j++;
            }
            i++;
        }
        return gano;
    }
    public boolean getInicializado(){
        return iniciado;
    }
    private void resetSumas(){
        for(int i = 0 ; i < tablero.length ; i++){
            for(int j = 0; j < tablero.length ; j++){
                tablero[i][j].setSumada(false);
            }
        }
    }
    private void iniciarTablero(){
        for(int i = 0 ; i < tablero.length ; i++){
            for(int j = 0; j < tablero.length ; j++){
                tablero[i][j] = new Celda() ;
            }
        }
    }
    public boolean todasOcupadas(){
        boolean rta = true;
        int i = 0 ;
        int j = 0; 
        while( i < tablero.length && rta){
            j = 0;
            while(j < tablero.length && rta ){
                if(!tablero[i][j].getOcupada()){
                    rta = false;
                }
                j++;
            }
            i++;
        }
        return rta;
    }
    public boolean perdio(){
        boolean perdio = true;
        if(todasOcupadas()){
            int i = 0;
            int j = 0;
            while(i < tablero.length -1 && perdio){
                j = 0;
                while(j < tablero.length && perdio){
                    if(tablero[i][j].getValor() == tablero[i + 1][j].getValor()){
                        perdio = false;
                    }
                    j++;
                }
                i++;
            }
            i = 0;
            j = 0;
            while(j < tablero.length -1 && perdio ){
                i = 0;
                while(i < tablero.length && perdio){
                    if(tablero[i][j].getValor() == tablero[i][j + 1].getValor()){
                        perdio = false;
                    }
                    i++;
                }
                j++;
            }
        }else{
            perdio = false;
        }
        return perdio;
    }
}
