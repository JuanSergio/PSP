/*
Parking donde se controle el numero de plazas disponibles y donde van entrando 
un numero superior de coches
*/

package EjercicioParking;

public class Parking {
    public static void main(String[] args) {
        Barrera entrada = new Barrera(3);
        Barrera entrada2 = new Barrera(4);
        //Bucle donde 10 será el numero total de coches
        for(int i = 0; i<10; i++){
            //se crean los coches que seran la posicion de i 
            Coche coche = new Coche ("Coche " + i, entrada);
            coche.start();
            
            //Se crea el tiempo de espera del coche aparcado, valor random
            long tEspera = (long) (Math.random()*7+1)*1000;
            try{
                Thread.sleep(tEspera);
            }catch(InterruptedException e){
                //indica si hay errores
                e.printStackTrace();
            }
            
        }
        for(int i = 0; i<7; i++){
            //se crean las motos que seran la posicion de i 
            Moto moto = new Moto ("Moto " + i, entrada2);
            moto.start();
            
            //Se crea el tiempo de espera de la moto aparcada, valor random
            long tEspera = (long) (Math.random()*7+1)*1000;
            try{
                Thread.sleep(tEspera);
            }catch(InterruptedException e){
                //indica si hay errores
                e.printStackTrace();
            }
            
        }
       
    }   
        
}    
    class Coche extends Thread{
        private String nombre;
        private Barrera barrera;

        public Coche(String nombre, Barrera barrera) {
            this.nombre = nombre;
            this.barrera = barrera;
        }
        //Al ser un hilo tiene que tener un run
        public void run(){
            
            barrera.entrar(nombre);
            //una vez entra cuenta como que ha aparcado
            System.out.println(nombre + " he aparcado y espero");
            //ya aparcado espera
            Espera.espera(5000);
            
            barrera.salir(nombre);
            
        }
       
    }
class Moto extends Thread{
        private String nombre;
        private Barrera barrera;

        public Moto(String nombre, Barrera barrera) {
            this.nombre = nombre;
            this.barrera = barrera;
        }
        //Al ser un hilo tiene que tener un run
        public void run(){
            
            barrera.entrar(nombre);
            //una vez entra cuenta como que ha aparcado
            System.out.println(nombre + " he aparcado y espero");
            //ya aparcado espera
            Espera.espera(5000);
            
            barrera.salir(nombre);
            
        }
       
    }
    //Huecos se encargará de gestionar los huecos disponibles
    class Barrera{
        private int huecos;
        public Barrera(int huecos) {
            this.huecos = huecos;
        }
        //entrar estará sincronizado para que vayan en orden
        public void entrar(String nombre){
            synchronized(this){
                try{
                    //si no hay huecos no va a entrar el coche por lo tanto espera
                    while (huecos < 1){
                        System.out.println(nombre +" no puedo entrar");
                        wait();
                    }
                    //huecos-- restara los huecos disponibles
                    huecos--;
                }catch (InterruptedException e){
                    System.out.println(nombre + " se ha interrumpido");
                    
                }
            }
            System.out.println(nombre +" entrando. Plazas disponibles: " + huecos);
            Espera.espera(5000);
            
        }
        
        
        public synchronized void salir(String nombre){
            huecos++;
            notifyAll();
            System.out.println(nombre +" saliendo. Plazas: " + huecos);
        }
    }
        class Espera{
            public static void espera (long espera){
                try{
                    Thread.sleep(espera);
                }catch(InterruptedException e){
                    System.out.println("Hilo de coche interrumpido");
                    System.exit(-1);
                }
            }
        }
  
    

