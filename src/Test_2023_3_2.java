import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

public class Test_2023_3_2 {

//  生产者 消费者 模型
    public static void main(String[] args) {
        // 创建一个阻塞队列作为生产者、消费者 进行业务的场所
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        // 创建一个线程作为生产者
        Thread producer = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        // 相当于生产数据
                        blockingQueue.put(i);
                        System.out.println("生产者生产了数据："+i);

                        // 每生产1个数据休息1s
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        producer.start();

        // 创建一个线程作为消费者，取数据
        Thread customer = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        Integer i = blockingQueue.take();
                        System.out.println("消费者消费了数据:"+ i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        customer.start();

        try {
            producer.join();
            customer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("消费结束!");


    }

    public static void main3(String[] args) {
        // 创建线程的几种方式

        //1、继承Thread类，重写run方法。 或者匿名内部类重写Run方法
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("创建了线程!");
            }
        };

        //2、实现Runable接口，作为参数填到Thread中
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("创建了线程!");
            }
        });

        //3、实现callable接口，FutureTask进行接收，作为参数填到Thread中
        FutureTask<Integer> futureTask = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("拥有返回值的call方法创建了线程的任务");
                return 2;
            }
        });

        Thread t3 = new Thread(futureTask);
//        t3.start();

        // 线程任务的返回值可以通过 futureTask.get() 获取到
//        try {
//            int a= futureTask.get();
//            System.out.println("futureTask获取返回值: "+a);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        // 4、使用线程池的方法创建线程
        ExecutorService executorService =  Executors.newFixedThreadPool(5);// 创建了包含5个核心线程的线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程开始工作");
            }
        });


    }

    public static void main2(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        // 表示某个资源只能同时被3个线程所持有

        // 下面这个循环相当于5个线程去访问资源，3个一直占着不放，只要不放其他的线程不能进行访问
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(){
//                @Override
//                public void run() {
//                    try {
//                        semaphore.acquire();// 相当于申请资源
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+": 成功申请了资源，暂时不释放");
//                }
//            };
//            thread.start();
//        }

        // 下面这个循环相当于5个线程去访问资源，过了5S,都进行释放，只要不放其他的线程不能进行访问
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        semaphore.acquire();// 相当于申请资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+": 成功申请了资源，5s后释放");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    semaphore.release();
                }
            };
            thread.start();
        }


    }

    // countDownLatch 倒计时锁存器的使用
    public static void main1(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("该选手已经撞线了!!");
                countDownLatch.countDown();
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        countDownLatch.await();

        System.out.println("               ");
        System.out.println("8位选手比赛均已完毕，请进行颁奖典礼!");

    }


}
