class Buffer {
    static boolean[] arr = new boolean[5];  //Size of Buffer is Set to 5
    static int bindex = 0;
}

class Producer extends Buffer implements Runnable {
    @Override
    public void run() {
       while(true){
            synchronized (arr) {
                while(bindex==5) {
                    try {
                        arr.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                arr[bindex] = true; // Producer placed 1 unit
                System.out.printf("Producer Placed item in : %d      ", bindex);
                bindex++;
                for (boolean x : arr) System.out.print(x + " ");
                System.out.println();

                arr.notify(); // Notify Consumer
            try {                
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            }
        }
    }
}

class Consumer extends Buffer implements Runnable {
    @Override
    public void run() {
       while(true){
            synchronized (arr) {
                while(bindex==0) {
                    try {
                        arr.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                bindex--;
                arr[bindex] = false; // Consumer consumed 1 unit
                System.out.printf("Consumer consumed item in : %d    ", bindex);
                for (boolean x : arr) System.out.print(x + " ");
                System.out.println();

                arr.notify(); // Notify Producer
            
            try {                
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
}

public class ProducerConsumer {
    public static void main(String args[]) throws InterruptedException {
        Thread prod = new Thread(new Producer());
        Thread cons = new Thread(new Consumer());

        prod.start();
        cons.start();

        prod.join();
        cons.join();

        System.out.println("DONE");
    }
}
