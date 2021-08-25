public class Celda
{
    private int valor;
    private boolean ocupada;
    private boolean sumada;
    public Celda (){
        valor = 0;
        ocupada = false;
        sumada  = false;
    }
    public void setValor(int v){
        valor = v;
    }
    public int getValor(){
        return valor;
    }
    public void setOcupada(boolean o){
        ocupada = o;
    }
    public boolean getOcupada(){
        return ocupada;
    }
    public void setSumada(boolean s){
        sumada = s;
    }
    public boolean getSumada(){
        return sumada;
    }
}
