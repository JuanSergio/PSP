package Filosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {

    //el id para saber el numero del filosofo
    private final int idFilosofo;

    //array de semaforo cada semaforo es un palillo
    private final Semaphore[] palillos_semaforo;

    //array bidimensional para cada palillo
    private final int[][] palillosFilosofo;
    
    private final int palilloIzquierda;
    private final int palilloDerecha;

    //se cra teimpo aleatorio para usarlo en comer y pensar
    private final Random tiempoAleatorio = new Random();

    public Filosofo(int idFilosofo, Semaphore[] palillos_semaforo, int[][] palillosFilosofo) {
        this.idFilosofo = idFilosofo;
        this.palillos_semaforo = palillos_semaforo;
        this.palillosFilosofo = palillosFilosofo;
        this.palilloIzquierda = palillosFilosofo[idFilosofo][0];
        this.palilloDerecha = palillosFilosofo[idFilosofo][1];
    }


    //Crear que el filosofo coma y descanse

    protected void comer() {
        //Primero tendrá que buscar si puede conseguir el cubierto izquierdo con boolean
        //luego buscara el derecho. El metodo es tryAcquire
        if (palillos_semaforo[palilloIzquierda].tryAcquire()) {
            if (palillos_semaforo[palilloDerecha].tryAcquire()) {
                System.out.println("Filosofo " + idFilosofo + " está comiendo");
                try {
                    //simular tiempo que esta comiendo entre 0.5 y 1 segundo
                    sleep(tiempoAleatorio.nextInt(1000) + 5000);

                } catch (InterruptedException e) {
                    System.out.println("ERROR" + e.toString());
                }
                //cuando termina suelta sus dos palillos
                System.out.println("El filosofo " + idFilosofo + " ha terminado de comer."
                        + "Libera los palillos " + palilloIzquierda + palilloDerecha);
                palillos_semaforo[palilloDerecha].release();
            }
            palillos_semaforo[palilloIzquierda].release();
        } else {//el filosofo no ha podido comer
            System.out.println("El filosofo " + idFilosofo + " esta hambriento");
        }
    }
    //ahora se crea que el filosofo esta pensando simulando que duerme
    protected void pensar(){
        System.out.println("El filosofo " + idFilosofo + " esta pensando");
        try{//tiempo que tarda el filosofo en pensar
            Filosofo.sleep(tiempoAleatorio.nextInt(1000)+100);
            
        }catch(InterruptedException e){
            System.out.println("ERROR en el metrodo pensar" + e.toString());
            
        }
    }
    @Override
    public void run(){
        while (true){
            pensar();
            comer();
        }
    }

}
