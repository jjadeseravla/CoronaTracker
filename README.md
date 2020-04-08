# Coronavirus Tracker App

Latest information on reported cases of coronavirus
for each place in each country and the changes of the number
of cases from the previous day for each place in each country.  
Info is updated daily on this app and taken from:
```https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv```</br>

## To Run:
You will need Java 11 to run this app and then simply clone this app and navigate to:
```/Users/jadealvares/Documents/Practise/coronatracker/src/main/java/io/javabrains/coronatracker/CoronatrackerApplication.java```</br>
Run this file from IntelliJ or on the terminal and navigate to: ```localhost:1212```</br>

## Tech Used:
- Java 11
- Springboot 2.2.6
- Thymeleaf templating engine
- HTML

## To Do: 
 - State and values have been saved in Spring services and this should be avoided. Normally services are stateless.
 - Data validity depends on source.
 - Need tests!
 