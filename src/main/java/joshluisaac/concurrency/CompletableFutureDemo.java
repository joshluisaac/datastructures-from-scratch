package joshluisaac.concurrency;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;
import lombok.Value;

public class CompletableFutureDemo {

  public static void printThreadInfo(String methodName, Thread thread) {
    System.out.println(methodName + "[" + thread.currentThread().getName() + " thread]");
  }

  public static void main(String[] args) throws Exception {
    OrderService orderService = new OrderService();
    Map<Integer, Order> orders = OrderData.getOrders();
    printThreadInfo("main", Thread.currentThread());
    ExecutorService executorService = Executors.newFixedThreadPool(5);


    Runnable task1 = () -> {
      System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException ex) {
        throw new IllegalStateException(ex);
      }
    };

    Runnable task2 = () -> {
      System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
      try {
        TimeUnit.SECONDS.sleep(4);
      } catch (InterruptedException ex) {
        throw new IllegalStateException(ex);
      }
    };

    Runnable task3 = () -> {
      System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException ex) {
        throw new IllegalStateException(ex);
      }
    };


    executorService.submit(task1);
    executorService.submit(task2);
    executorService.submit(task3);



    List<Future<Order>> futureOrders = new ArrayList<>();
    IntStream.range(0, 10)
        .forEach(
            entry -> {
              Future<Order> orderFuture =
                  CompletableFuture.supplyAsync(
                          () -> orderService.createOrder(entry), executorService)
                      .thenApplyAsync(row -> orderService.verifyOrder(row, entry), executorService)
                      // uses a forkJoinPool as default executor if executor isn't specified
                      .thenApplyAsync(row -> orderService.enrichOrder(row, entry))
                      .thenApplyAsync(row -> orderService.updateOrder(row, entry), executorService)
                      .thenApplyAsync(
                          row -> orderService.dispatchOrder(row, entry), executorService)
                      .thenApplyAsync(row -> orderService.sendEmail(row, entry), executorService);

              if (entry == 0) {
                futureOrders.add(orderFuture);
              }
            });

    System.out.println(futureOrders.size() + " By " + Thread.currentThread().getName());
    System.out.println(futureOrders.get(0).get());
    System.out.println("Got here....");
    executorService.shutdown();
    executorService.awaitTermination(3, TimeUnit.SECONDS);
  }
}

@Builder
@Value
@AllArgsConstructor
class Order {
  String customerName;
  LocalDateTime orderDate;
  String orderStatus;
}

class OrderData {
  private static final Map<Integer, Order> orders = new HashMap<>();

  static {
    orders.put(1, new Order("Justin", LocalDateTime.now(), "NEW"));
    orders.put(2, new Order("Blake", LocalDateTime.now(), "NEW"));
    orders.put(3, new Order("Josh", LocalDateTime.now(), "NEW"));
    orders.put(4, new Order("Lucas", LocalDateTime.now(), "NEW"));
  }

  public static Map<Integer, Order> getOrders() {
    return orders;
  }
}

class OrderService {

  Order createOrder(int i) {
    CompletableFutureDemo.printThreadInfo("row" + i + " createOrder", Thread.currentThread());
    return Order.builder()
        .customerName("A0" + i)
        .orderStatus("NEW")
        .orderDate(LocalDateTime.now())
        .build();
  }

  Order getOrder(Integer orderId) {
    CompletableFutureDemo.printThreadInfo("getOrder", Thread.currentThread());
    return OrderData.getOrders().get(orderId);
  }

  Order verifyOrder(Order order, int entry) {
    CompletableFutureDemo.printThreadInfo("row" + entry + " verifyOrder", Thread.currentThread());
    return order;
  }

  Order enrichOrder(Order order, int entry) {
    CompletableFutureDemo.printThreadInfo("row" + entry + " enrichOrder", Thread.currentThread());
    return order;
  }

  Order updateOrder(Order order, int entry) {
    CompletableFutureDemo.printThreadInfo("row" + entry + " updateOrder", Thread.currentThread());
    return order;
  }

  @SneakyThrows
  Order dispatchOrder(Order order, int entry) {
    CompletableFutureDemo.printThreadInfo("row" + entry + " dispatchOrder", Thread.currentThread());
    // Thread.sleep(5000);
    return Order.builder()
        .orderDate(order.getOrderDate())
        .customerName("DISPATCHED: " + order.getCustomerName())
        .orderStatus(order.getOrderStatus())
        .build();
  }

  Order sendEmail(Order order, int entry) {
    String x = order.getCustomerName() + "XXX ";
    CompletableFutureDemo.printThreadInfo("row" + entry + " sendEmail", Thread.currentThread());
    return order;
  }
}
