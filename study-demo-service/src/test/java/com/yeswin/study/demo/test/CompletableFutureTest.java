package com.yeswin.study.demo.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    /**
     * CompletableFuture 基于事件回调，可以等待事件执行完成接受回调。
     * Future.get() 需要阻塞
     * 同时类似 RxJava 有几种操作符， thenRun 、thenAccept、thenCombine、thenApply等
     */
    @Test
    public void test() {
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        }).thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        });

//        CompletableFuture.runAsync(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).thenApply()
    }
}
