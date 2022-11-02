/**
 * 
 */
package org.vj.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vj.pojo.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author vijayakumar
 * @Since  30-Oct-2022
 *
 */

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@GetMapping(value = "/getAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Order> getAll() {
		Flux<Order> fluxOrder = Flux.just(
				new Order(1L, 100.00),
				new Order(2L, 100.00),
				new Order(3L, 100.00),
				new Order(4L, 100.00),
				new Order(5L, 100.00),
				new Order(6L, 100.00),
				new Order(7L, 100.00),
				new Order(8L, 100.00),
				new Order(9L, 100.00),
				new Order(10L, 100.00))
				.delayElements(Duration.ofSeconds(1L))
				.log();
		
		return fluxOrder;
	}

	@GetMapping(value = "/traditional/getAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public List<Order> traditionalGetAll() {
		List<Order> listOrder = Arrays.asList(
				new Order(1L, 100.00),
				new Order(2L, 100.00),
				new Order(3L, 100.00),
				new Order(4L, 100.00),
				new Order(5L, 100.00),
				new Order(6L, 100.00),
				new Order(7L, 100.00),
				new Order(8L, 100.00),
				new Order(9L, 100.00),
				new Order(10L, 100.00));
		
		listOrder = listOrder.stream().peek(order -> {
			System.out.println(order.getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).collect(Collectors.toList());
		
		return listOrder;
	}
	
	@GetMapping("/getOne")
	public Mono<Order> getOne() {
		Mono<Order> mono = Mono.just(new Order(1L, 100.00));
		return mono;
	}
}
