package xyz.rennder.parallel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rennder.parallel.service.ProcessService;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    ProcessService processService;

    @PostMapping("/serial")
    public List<String> serial(@RequestBody String[] listData) {

        List<String> result = processService.runSerial(listData);

        return result;
    }

    @PostMapping("/parallel")
    public List<String> parallel(@RequestBody String[] listData) {

        List<String> result = processService.runParallel(Arrays.stream(listData).parallel());

        return result;
    }

}
