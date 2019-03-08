import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class MainApp {
    private static final int ARRAY_CAPACITY = 10_000;


    public static final int MAX_VALUE = 1000;

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        Supplier<Array> constructor = ArrayImpl::new;

        Array arr1 = createArray(constructor);
        Array arr2 = createArray(constructor);
        Array arr3 = createArray(constructor);

        randomInitialize(arr1, arr2, arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(measureTime(arr1::sortBubble, "Sort Bubble"));
        executorService.execute(measureTime(arr1::sortSelect, "Sort Select"));
        executorService.execute(measureTime(arr1::sortInsert, "Sort Insert"));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static void randomInitialize(Array... arrays) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (Array array : arrays) {
                array.add(value);
            }
        }
    }

    private static Runnable measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.println(String.format("%s took time: %d ms.",
                    actionName,
                    TimeUnit.NANOSECONDS.toMillis(duration)));
        };

    }

    private static Array createArray(Supplier<Array> factory) {
        return factory.get();
    }

}
