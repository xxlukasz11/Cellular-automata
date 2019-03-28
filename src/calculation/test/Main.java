package calculation.test;

import calculation.automat.*;
import calculation.random.Generator;
import calculation.random.LambdaGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static double calculateEntropy(Rule rule){
        EntropyCollector collect = new EntropyCollector(rule, 10000);
        return collect.calculateAverageEntropy(1);
    }

    public static void main(String[] args) {
        int threadCount = 5;
        List<Thread> threadPool = new ArrayList<>(threadCount);
        Rule rule = new LambdaRule(2, 0.2);

        for(int i = 0; i < threadCount; ++i){
            threadPool.add(new Thread( () -> System.out.println(calculateEntropy(rule)) ));
            threadPool.get(i).start();
        }

        System.out.println( calculateEntropy(rule) );

        try {
            for(var thread : threadPool)
                thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
