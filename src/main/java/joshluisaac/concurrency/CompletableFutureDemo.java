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

  public static void printThreadInfo(Thread thread) {
    System.out.println(thread.currentThread().getName() + " thread");
  }

  public static void main(String[] args) throws Exception {
    OrderService orderService = new OrderService();
    Map<Integer, Order> orders = OrderData.getOrders();
    printThreadInfo(Thread.currentThread());
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    List<Future<Order>> futureOrders = new ArrayList<>();
    IntStream.range(0, 1)
        .forEach(
            entry -> {
              Future<Order> orderFuture =
                  CompletableFuture.supplyAsync(
                          () -> orderService.createOrder(entry), executorService)
                      .thenApplyAsync(orderService::verifyOrder, executorService)
                      .thenApplyAsync(
                          (orderService
                              ::enrichOrder)) // uses a forkJoinPool as default executorService
                      .thenApplyAsync(orderService::updateOrder, executorService)
                      .thenApplyAsync(orderService::dispatchOrder, executorService);
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
    return Order.builder()
        .customerName("A0" + i)
        .orderStatus("NEW")
        .orderDate(LocalDateTime.now())
        .build();
  }

  Order getOrder(Integer orderId) {
    CompletableFutureDemo.printThreadInfo(Thread.currentThread());
    return OrderData.getOrders().get(orderId);
  }

  Order verifyOrder(Order order) {

    CompletableFutureDemo.printThreadInfo(Thread.currentThread());
    return order;
  }

  Order enrichOrder(Order order) {
    CompletableFutureDemo.printThreadInfo(Thread.currentThread());

    return order;
  }

  Order updateOrder(Order order) {
    CompletableFutureDemo.printThreadInfo(Thread.currentThread());
    return order;
  }

  @SneakyThrows
  Order dispatchOrder(Order order) {
    CompletableFutureDemo.printThreadInfo(Thread.currentThread());
    System.out.println("Running dispatchOrder: " + Thread.currentThread().getName());
    Thread.sleep(5000);
    return Order.builder()
        .orderDate(order.getOrderDate())
        .customerName("DISPATCHED: " + order.getCustomerName())
        .orderStatus(order.getOrderStatus())
        .build();
  }

  void sendEmail(Order order) {
    System.out.println("Running sendEmail");
  }
}
