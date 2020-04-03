package io.javabrains.coronatracker.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CoronaVirusDataService {

    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    //make HTTP Call to URL
    @PostConstruct//this annotation means execute this when the app starts
    //After you've constructed this instance of the @Service, execute the fetchVirusData() method
    public void fetchVirusData() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        //create a request using the builder pattern
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(VIRUS_DATA_URL)) //says where you need to access
                                         .build();

        //second argument in send() is the body handler where we are taking the body and returning it as a string
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.body());
    }

}
