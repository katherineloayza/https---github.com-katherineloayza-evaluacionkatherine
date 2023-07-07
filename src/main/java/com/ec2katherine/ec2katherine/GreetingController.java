package com.ec2katherine.ec2katherine;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "su Nombres ,  %s!";
    private static final String template2 = "su Codigo es: , %s!";
    private static final String template3 = "Nombres Completos: , %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "ln73747096 - Katherine") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

    @GetMapping("/idat/codigo")
	public Greeting greetingCodigo(@RequestParam(value = "name", defaultValue = "ln73747096") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template2, name));
	}

    @GetMapping("/idat/nombre-completo")
	public Greeting greetingNombre(@RequestParam(value = "name", defaultValue = "Katherine") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template3, name));
	}


}