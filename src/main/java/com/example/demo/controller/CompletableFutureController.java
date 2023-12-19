package com.example.demo.controller;

import com.example.demo.entity.Boy;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2023年10月30日11:43:33
 **/

@RestController
public class CompletableFutureController {



//    @RequestMapping("/completablefuture/hello")
//    public String hello(){
//
//        Arrays.asList(
//                new Boy("BestPrice"),
//                new Shop("LetsSaveBig"),
//                new Shop("MyFavoriteShop"),
//                new Shop("BuyItAll"));
//
//        return "success";
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        thenApplyThenApplyAsync();
    }
    public static void main1(String[] args) throws ExecutionException, InterruptedException {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu 核数"+i);
        System.out.println("cpu 核数"+i);

        long start = System.currentTimeMillis();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future1  "+ Thread.currentThread().getId());
            }
//            long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
//            //System.out.println("future1 总耗时:"+ cost+"秒");

        });

        // 2

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future2  "+ Thread.currentThread().getId());
            }
//            long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
            //System.out.println("future2 总耗时:"+ cost+"秒");
            //return cost;
        });

        // 3
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future3  "+ Thread.currentThread().getId());
            }
//            long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
//            //System.out.println("future3 总耗时:"+ cost+"秒");
//            return cost;
        });

        // 4
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future4  "+ Thread.currentThread().getId());
            }
//            long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
//            //System.out.println("future4 总耗时:"+ cost+"秒");
//            return cost;
        });

        //5
        CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future5  "+ Thread.currentThread().getId());
            }
//            long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
//            //System.out.println("future5 总耗时:"+ cost+"秒");
//            return cost;
        });

        //6
        CompletableFuture<Void> future6 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future6  "+ Thread.currentThread().getId());
            }
//            long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
//            //System.out.println("future6 总耗时:"+ cost+"秒");
//            return cost;
        });
        //7
        CompletableFuture<Void> future7 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future7  "+ Thread.currentThread().getId());
            }
//            long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
//            //System.out.println("future7 总耗时:"+ cost+"秒");
//            return cost;
        });

        // 8
        CompletableFuture<Void> future8 = CompletableFuture.runAsync(() -> {
            //long startTime = System.currentTimeMillis();
            for(int a=0;a<=100000000;a++){
                System.out.println("future8  "+ Thread.currentThread().getId());
            }
            //long endTime = System.currentTimeMillis();
//            long cost = (endTime - startTime) / 1000;
//            //System.out.println("future8 总耗时:"+ cost+"秒");
//            return cost;
        });

//      当所有给定的 CompletableFuture 完成时，返回一个新的 CompletableFuture
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1,
                future2,
                future3,
                future4,
                future5,
                future6,
                future7,
                future8
                );
        try {
            // 阻塞 等待 各个任务执行
            voidCompletableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long cost = (end - start) / 1000;
        //  800 0000 总耗时:24秒
        //  8000 0000 总耗时:300秒
        //8 0000 0000 总耗时:4324秒
        System.out.println("总耗时:"+ cost+"秒");

    }



    /**
     * 功能描述： 打印八千万
     * @author guoyiguang
     * @date 2023/11/3
     * @param
     * @return
     */
    public static  String task(){
        for(int i=0;i<=800000000;i++){
            System.out.println(Thread.currentThread().getId());
        }

        return "";
    }

    // 线程是操作系统能够调度的最小单位。为什么需要多线程呢？
    // 因为我们的CPU的运算速度是非常的快的，在一个应用程序的运行过程中的大部分时间，都花在了，I/O操作，网络请求，
    // 和数据库操作上。如果没有多线程，我们的CPU大部分时间都是处于等待的状态，对CPU的资源造成了极大的浪费。
    // 多线程就是多个线程去共享CPU的时间片。一个CPU在一个固定的时间点，一个CPU只会处理一条线程中的指令。
    // 提高了CPU的利用率，注意并不是提高了CPU的执行速度。


//   结论：java线程越多程序越快吗? java多线程比单线程慢
//    当一个任务并不是真正的耗时操作时。单线程执行它的效率远比开启多个线程执行它的效率要高的多。因为在创建多个线程时，
//    创建线程的开销，和执行过程的线程上下切换的开销，远比执行这个任务的开销要多的多。当一个任务是真正得耗时任务时,
//    我们有必要去合理得创建线程去执行它，来提高CPU的使用率。
//
//    所以在我们的日常开发中，要平衡创建线程和执行任务的开销，如果这个任务不值得我们为它开启一个线程去执行，那么就不要去创建线程。
//    推荐使用线程池，而不要使用new Thread()的方式，因为如果存在大量的耗时的任务的时候，Thread的频繁创建和销毁，
//    也是有一定的开销的，线程池可以为我们带来线程的复用。




   public static void thenApplyThenApplyAsync() throws ExecutionException, InterruptedException {

       CompletableFuture<List<Map<String,Object>>> orgFuture = CompletableFuture.supplyAsync(
               ()->{
                   List<Map<String,Object>> result = new ArrayList<>();
                   Map<String,Object> m = new HashMap<>();
                   m.put("name","三");
                   result.add(m);
                   return result;
               }
       );

       CompletableFuture<List<Map<String,Object>>> thenApplyFuture = orgFuture.thenApply((a) -> {
           System.out.println("入参："+a);
           Map<String,Object> m = new HashMap<>();
           m.put("name","四");
           a.add(m);

           return a;
           // 打印异常
       }).exceptionally((e) -> {
           e.printStackTrace();
           return new ArrayList<>();
       });;


       System.out.println(thenApplyFuture.get());

    }



}
