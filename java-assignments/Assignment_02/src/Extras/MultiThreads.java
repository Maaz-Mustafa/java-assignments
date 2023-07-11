package Extras;

public class MultiThreads {

    private static int number;
    boolean threadOneFlag ;

    public MultiThreads(int number){
        this.number=number;
    }
    public synchronized void printIntegers(Thread thread) {


        for(int i=1;i<=5;i++)
        {
            try{
                if(threadOneFlag){
                    System.out.println(number + " Thread :- " + thread.getName());
                    number++;
                    threadOneFlag = false;
                    wait();
                    notify();
                }else{
                    System.out.println(number + " Thread :- " + thread.getName());
                    number++;
                    notify();
                    threadOneFlag=true;
                    wait();
                }
            }
            catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}

class MyThread1 extends Thread{
    MultiThreads multi;
    public MyThread1(MultiThreads multi){
        this.multi=multi;
    }

    @Override
    public void run() {
        multi.printIntegers(this.currentThread());
    }
}

class MyThread2 extends Thread{
    MultiThreads multi;
    public MyThread2(MultiThreads multi){
        this.multi=multi;
    }

    @Override
    public void run() {
        multi.printIntegers(this.currentThread());
    }
}

class Main{
    public static void main(String[] args) {
        MultiThreads m=new MultiThreads(10);
        m.threadOneFlag=true;
        MyThread1 t1=new MyThread1(m);
        MyThread2 t2=new MyThread2(m);
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}