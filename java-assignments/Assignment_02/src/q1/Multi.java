package q1;

class Multi {
    public synchronized void printIntegers(int number){

        for(int i=0;i<=9;i++){
            System.out.println(number+i);
        }
        try{
            Thread.sleep(400);
        }catch(Exception e){System.out.println(e);}
    }
}


class MyThread1 extends Thread{
    Multi multi;
    public MyThread1(Multi multi){
        this.multi=multi;
    }

    @Override
    public void run() {
        multi.printIntegers(1);
    }
}

class MyThread2 extends Thread{
    Multi multi;
    public MyThread2(Multi multi){
        this.multi=multi;
    }

    @Override
    public void run() {
        multi.printIntegers(101);
    }
}

class Main{
    public static void main(String[] args) {
        Multi m=new Multi();
        MyThread1 t1=new MyThread1(m);
        MyThread2 t2=new MyThread2(m);
        t1.start();
        t2.start();
    }
}



