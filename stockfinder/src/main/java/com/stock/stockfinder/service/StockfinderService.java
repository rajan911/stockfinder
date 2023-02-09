package com.stock.stockfinder.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class StockfinderService {

    public String stockFinder(String symbol){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol="+symbol+"&apikey=EB76TOITOJU1COMH";
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        return response.getBody();
    }

    public String downloadCsv(String symbol){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol="+symbol+"&apikey=EB76TOITOJU1COMH&datatype=csv";
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        return response.getBody();
    }
}
