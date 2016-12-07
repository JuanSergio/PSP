/*
 Cinco filósofos alrededor de una mesa pasan su vida comiendo o pensando. Cada 
 filósofo tiene un plato de arroz y un palillo a la izquierda de su plato. 
 Cuando un filósofo quiere comer, cogerá los dos palillos de cada lado del plato 
 y comerá. 
 */
package Filosofos;

import java.util.concurrent.Semaphore;

public class Main {

    final static int numeroFilosofos = 5;

    /*Array de bidimensional con el mismo numero de filas que de filosofos
     * es un array de 2 enteros que representan los 2 palillos del filósofo, el 
     * de su izquierda y el de su derecha, en ese orden
     */
    final static int[][] palillosFilosofo = {
        //el filosofo cogerá su tenedor propio y el de su izquierda
        {4, 0},//filosofo 0
        {0, 1},//filosofo 1
        {1, 2},//filosofo 2
        {2, 3},//filosofo 3
        {3, 4},//filosofo 4
    };

    //Se crea el semaforo en forma de array que representara el numero de palillos
    public static Semaphore[] palillos_semaforo = new Semaphore[numeroFilosofos];

    public static void main(String[] args) {
        for (int i = 0; i < numeroFilosofos; i++) {
            //un palillo por cada filosofo
            palillos_semaforo[i] = new Semaphore(1);
        }
        for (int idFilosofo = 0; idFilosofo < numeroFilosofos; idFilosofo++) {
            new Filosofo(idFilosofo, palillos_semaforo, palillosFilosofo).start();
        }
    }

}
