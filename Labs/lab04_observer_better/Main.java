import java.util.Scanner;
import javax.swing.*;
import java.util.Random;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {

        // This is an observer of stock information (pushed out to a "database")
        //DataFile db = new DataFile("dbtest.csv");

        // The subjects
        StockMarket stockMarket = new StockMarket();
        WeatherStation weatherStation = new WeatherStation();
        NewsAP theNews = new NewsAP();

        // The observers
        StockWatcher stockWatcher = new StockWatcher(stockMarket);
        Newsfeed newsFeed = new Newsfeed(theNews,weatherStation,stockMarket);
        Database database = new Database(stockMarket);

        Thread stockThread = new Thread(stockMarket);
        Thread weatherThread = new Thread(weatherStation);
        Thread newsThread = new Thread(theNews);

        stockThread.start();
        weatherThread.start();
        newsThread.start();
        newsFeed.start();

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        while (true) {
            userInput = scanner.nextLine();
            System.out.println("************************* "+userInput);
        }
        //stockThread.interrupt();
        //weatherThread.interrupt();
        //newsThread.interrupt();
    }
}


        /* 

        // This is "sort of" pushing out information to all the observers
        long counter = 0;
        for (long i=0; i<1000000; i++) {

            // update the news
            String temp = "news";
            //temp += String.format("TEMP %d PREC %d%% AIR %d %n", temperature, precipitation, airQuality);
            // += String.format("DOW %.2f S&P %.2f 3M %.2f Microsoft %.2f %n", dow, snp, mmm, msft);
            if (counter%10 == 0) {
                temp = "News item "+counter/10+" is some very interesting news!";
                news.update(temp);
            }
            news.redraw();

            // update the database
            //db.addData("and another");
         
            // update the stock watcher 
            //System.out.printf("DOW %.2f S&P %.2f 3M %.2f Microsoft %.2f %n", dow, snp, mmm, msft);

            try {
                Thread.sleep(200);
                ++counter;
            } catch (InterruptedException e) {
            }
        }
    }    
}
*/
