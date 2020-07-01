package mybatisplus.demo.test.Runnable;

public class RunnableDemo implements Runnable{
    int j=20;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+",j="+this.j--);
        }
    }

    public static void main(String[] args) {
        RunnableDemo myRunnable = new RunnableDemo();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();

    }
}
