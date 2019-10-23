package com.lvat.SpringTest.consumingrest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController()
@RequestMapping(path = "/random-quote-getter")
public class QuoteController {
    private static RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(path = "/get-quote")
    public String getQuote(@RequestParam(value = "url", defaultValue = "https://gturnquist-quoters.cfapps.io/api/random") String url) {
        return Objects.requireNonNull(restTemplate.getForObject(url, Quote.class)).getValue().getQuote();
    }
}
