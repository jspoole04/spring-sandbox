package main.java.hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by joshua on 3/18/16.
 */
@RestController
@RequestMapping("api/greeting")
public class GreetingController {
    private static final String template = "Hello from GreetingController, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity greeting(@RequestParam(value="name", defaultValue = "World!") String name){
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        return ResponseEntity.ok(greeting);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity getGreetingById(@PathVariable Long id){
        Greeting greeting = new Greeting(id, String.format(template, "World"));
        return ResponseEntity.ok(greeting);
    }
}