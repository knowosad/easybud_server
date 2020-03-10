package pl.easybud.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.easybud.server.dto.OrderDTO;
import pl.easybud.server.service.OrderService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://127.0.0.1:8888")
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public OrderDTO create(@RequestBody OrderDTO dto) {
		return orderService.create(dto);
	}

	@GetMapping("/{id}")
	public OrderDTO read(@PathVariable Long id){
		return orderService.read(id);
	}

//	@CrossOrigin
	@GetMapping("/all")
	public List<OrderDTO> findAll(){
		return orderService.findAll();
	}


	//	TODO test
	@GetMapping("/test")
	public String greeting() {
		return "Hello World";
	}
}
