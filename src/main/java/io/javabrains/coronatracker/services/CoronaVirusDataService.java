package io.javabrains.coronatracker.services;

import io.javabrains.coronatracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {

    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<LocationStats> allStats = new ArrayList<>();

    //make HTTP Call to URL
    @PostConstruct//this annotation means execute this when the app starts
    //After you've constructed this instance of the @Service, execute the fetchVirusData() method
    @Scheduled(cron = "* * 1 * * *" )//schedules the run of a method on a regular basis
    //eg. * means it runs every second or every minute or every etc unless you specify a number
    public void fetchVirusData() throws IOException, InterruptedException {

        List<LocationStats> newStats = new ArrayList<>();

   /*     public List<LocationStats> getAllStats() {
            return allStats;
        }*/

        HttpClient client = HttpClient.newHttpClient();

        //create a request using the builder pattern
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(VIRUS_DATA_URL)) //says where you need to access
                                         .build();

        //second argument in send() is the body handler where we are taking the body and returning it as a string
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(httpResponse.body());

        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));

            int latestCases = Integer.parseInt(record.get(record.size() -1));
            int previousCases = Integer.parseInt(record.get(record.size() -2));

            locationStat.setLatestTotalCases(latestCases);
            locationStat.setDiffFromPreviousDay(latestCases - previousCases);

//            System.out.println(locationStat);
            newStats.add(locationStat);
            //String state = record.get("Province/State");
            //String customerNo = record.get("CustomerNo");
            //String name = record.get("Name");
        }
        this.allStats = newStats;
    }

    public List<LocationStats> getAllStats() {
        return allStats;
    }
}
