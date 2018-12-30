package xyz.rennder.parallel.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProcessService {

    public List<String> runSerial(String[] listData) {
        List<String> result = new ArrayList<>();

        for(String data : listData){

            processData(data, result);

        }

        return result;
    }

    public List<String> runParallel(Stream<String> listData) {
        List<String> result = new ArrayList<>();

        listData.forEach(data -> {
            processData(data, result);

        });

        return result;
    }

    private void processData(String data, List<String> result){

        // do some logic here
        // like convert data, call microservice api, etc.

        result.add(data+ "-done");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
