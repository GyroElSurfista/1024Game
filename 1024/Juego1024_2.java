public class Juego1024_2
{
    private int[][] tablero;
    private boolean[][] tableroAux;
    private boolean ganado;
    private boolean iniciado;
    public Juego1024_2(){
        tablero = new int[4][4];
        tableroAux = new boolean[4][4];
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
    public String mover(char movimiento){
        String resultado;
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
        return resultado;
    }
    public void moverAbajo(){
        for(int j =0  ; j < tablero.length ; j++ ){
            for(int i = tablero.length - 2 ; i >= 0 ; i--){
                if(tablero[i][j] == 0){
                
                }else{
                    int ind = i;
                    while(ind < tablero.length - 1 ){
                        while(tablero[ind +1][j] == 0 && ind < tablero.length - 2){
                            ind++; 
                        }
                        if(tablero[i][j] == tablero[ind + 1][j]){
                            tablero[ind + 1][j] = tablero[ind + 1][j] +tablero[i][j];
                            tableroAux[ind + 1][j] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else if(tablero[ind + 1][j] == 0){
                            tablero[ind + 1][j] =tablero[i][j];
                            tableroAux[ind + 1][j] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else{
                            if( i != ind && tablero[i][j] != 0){
                                tablero[ind][j] = tablero[i][j];
                                tableroAux[ind][j] = true;
                                tablero[i][j] = 0;
                                tableroAux[i][j] = false;
                                ind = tablero.length - 1;
                            }
                        }
                        ind++; 
                    }
                }
            }
        }   
    }
    public void moverArriba(){
        for(int j = 0; j < tablero.length ; j++){
            for(int i = 1 ; i < tablero.length ; i++){
                if(tablero[i][j] == 0){
                
                }else{
                    int ind = i;
                    while(ind > 0){
                        while(tablero[ind -1][j] == 0 && ind > 1){
                            ind++; 
                        }
                        if(tablero[i][j] == tablero[ind - 1][j]){
                            tablero[ind - 1][j] = tablero[ind - 1][j] +tablero[i][j];
                            tableroAux[ind - 1][j] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else if(tablero[ind - 1][j] == 0){
                            tablero[ind - 1][j] =tablero[i][j];
                            tableroAux[ind - 1][j] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else{
                            if( i != ind && tablero[i][j] != 0){
                                tablero[ind][j] = tablero[i][j];
                                tableroAux[ind][j] = true;
                                tablero[i][j] = 0;
                                tableroAux[i][j] = false;
                                ind = 0;
                            }
                        }
                        ind--; 
                    }
                }
            }
        }
    }
    public void moverIzquierda(){   
        for(int i = 0 ; i < tablero.length ; i++){
            for(int j = 1 ; j < tablero.length ; j++){
                if(tablero[i][j] == 0){
                    
                }else{
                    int ind = j;
                    while(ind > 0 ){
                        while(tablero[i][ind - 1] == 0 && ind > 1){
                            ind--;
                        }
                        if(tablero[i][ind - 1] == tablero[i][j]){
                            tablero[i][ind - 1] = tablero[i][ind -1] + tablero[i][j];
                            tableroAux[i][ind - 1] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else if(tablero[i][ind - 1] == 0){
                            tablero[i][ind - 1] = tablero[i][j];
                            tableroAux[i][ind - 1] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else{
                            if(i != ind && tablero[i][j] != 0){
                                tablero[i][ind] = tablero[i][j];
                                tableroAux[i][ind] = true;
                                tablero[i][j] = 0;
                                tableroAux[i][j] = false;
                                ind = 0;
                            }
                        }
                        ind--;
                    }                
                }
            }
        }
    }
    public void moverDerecha(){
        for(int i = 0  ; i < tablero.length ; i++ ){
            for(int j = tablero.length - 2 ; j >= 0 ; j--){
                if(tablero[i][j] == 0){
                    
                }else{
                    int ind = j;
                    while(ind < tablero.length - 1){
                        while(tablero[i][ind + 1] == 0 && ind < tablero.length - 2){
                            ind++;
                        }
                        if(tablero[i][ind + 1] == tablero[i][j]){
                            tablero[i][ind + 1] = tablero[i][ind + 1] + tablero[i][j];
                            tableroAux[i][ind + 1] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else if(tablero[i][ind + 1] == 0){
                            tablero[i][ind + 1] = tablero[i][j];
                            tableroAux[i][ind + 1] = true;
                            tablero[i][j] = 0;
                            tableroAux[i][j] = false;
                        }else{
                            if(i != ind && tablero[i][j] != 0){
                                tablero[i][ind] = tablero[i][j];
                                tableroAux[i][ind] = true;
                                tablero[i][j] = 0;
                                tableroAux[i][j] = false;
                                ind = tablero.length - 1;
                            }
                        }
                        ind++;
                    }                
                }
            }
        }   
    }
    public void generarRandom(){
        boolean generado = false;
        int i = (int)(Math.random() * tablero.length);
        int j = (int)(Math.random() * tablero.length);
        int r = (int)(Math.random() * 2);
        while(r == 0){
            r = (int)(Math.random() * 2);
        }
        while(!generado){
            if(tableroAux[i][j]){
                i = (int)(Math.random() * tablero.length);
                j = (int)(Math.random() * tablero.length);
            }else{
                tablero[i][j] = r;
                tableroAux[i][j] = true;
                generado = true;
            }            
        }
    }
    public String mostrar(){
        String muestra = "";
        for(int i = 0 ;i < tablero.length ; i++){
            for(int j = 0 ; j < tablero[0].length ; j++){
                if(tablero[i][j] < 10){
                  muestra = muestra + "  " + tablero[i][j] + " ";
                }else if(tablero[i][j] >= 10 && tablero[i][j] < 100){
                    muestra = muestra +" " + tablero[i][j] + " ";
                }else{
                    muestra = muestra + tablero[i][j] + " ";
                }
            }
            muestra = muestra + "\n";
        }
        return muestra;
    }
    public void resetTablero(){
        for(int i = 0 ; i < tableroAux.length ; i++){
            for(int j = 0; j < tableroAux.length ; j++){
                tablero[i][j] = 0;
                tableroAux[i][j] = false;
            }
        }
    }
    public boolean ganaste(){
        boolean gano = false;
        int i = 0;
        int j = 0;
        while(i < tablero.length && !gano){
            j = 0;
            while(j < tablero.length && !gano){
                if(tablero[i][j] == 1024){
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
}
