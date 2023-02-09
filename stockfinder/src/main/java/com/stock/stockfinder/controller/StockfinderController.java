package com.stock.stockfinder.controller;

import com.stock.stockfinder.service.StockfinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StockfinderController {

    @Autowired
    StockfinderService stockfinderService;

    @GetMapping(value = "stock", produces = "application/json")
    public String stockFinder(@RequestParam("symbol") Optional<String> symbol){
        if( symbol.isPresent()) {
            String resultResponse = stockfinderService.stockFinder(symbol.get());
            System.out.println(resultResponse);
            return resultResponse;
        } else{
            throw new IllegalArgumentException("Please provide valid stock symbol");
        }
    }

    @GetMapping(value = "downloadCSV", produces = "application/json")
    public String downloadCSV(@RequestParam("symbol") Optional<String> symbol){
        if( symbol.isPresent()) {
            String resultResponse = stockfinderService.downloadCsv(symbol.get());
            System.out.println(resultResponse);
            return resultResponse;
        } else{
            throw new IllegalArgumentException("Please provide valid stock symbol");
        }
    }

}
