/**
 * 
 */
package org.vj.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.vj.pojo.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author vijayakumar
 * @Since  31-Oct-2022
 *
 */
@Component
public class OrderHandler {
	
	public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(Flux.just(
						new Order(1L, 100.00),
						new Order(2L, 100.00),
						new Order(3L, 100.00),
						new Order(10L, 100.00)), Order.class);
	}
	
	public Mono<ServerResponse> getOne(ServerRequest serverRequest) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(
						new Order(1L, 100.00)), Order.class);
	}

}
