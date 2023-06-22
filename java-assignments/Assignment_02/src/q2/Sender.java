package q2;

public class Sender {
    public synchronized void send(String message){
        System.out.println(message);
    }
}

class ThreadedSend extends Thread{
    private String message;
    private Sender sender;
    public ThreadedSend(String message,Sender senderObject){
        this.message=message;
        this.sender=senderObject;
    }

    @Override
    public void run() {
       sender.send(message);
    }

}

class Demo{
    public static void main(String[] args) {
        Sender sender=new Sender();
        ThreadedSend thread1=new ThreadedSend("Hi",sender);
        ThreadedSend thread2=new ThreadedSend("Bye",sender);
        thread1.start();
        thread2.start();
    }
}