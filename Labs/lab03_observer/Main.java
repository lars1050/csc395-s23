import java.util.Scanner;
import javax.swing.*;
import java.util.Random;

public class Main {

    /** Graphics window inside JFrame on which to draw components */
    // This will be an observer of both stocks and weather
    static NewsDisplay news = new NewsDisplay(600,600);

    // This is subject information (for observing the stock market)
    static Double dow = 4016.22;    // dow jones
    static Double snp = 33743.84;   // S&P 500
    static Double mmm = 112.93;     // 3M stock price
    static Double msft = 240.61;    // Microsoft stock price

    // This is subject information (for observing the weather)
    static Integer temperature = 10;    //  minneapolis temp
    static Integer precipitation = 7;   //  chance of precip
    static Integer airQuality = 46;     //  air quality index

    static Random random = new Random();

    public static void main(String[] args) {

        // This is an observer of stock information (pushed out to a "database")
        DataFile db = new DataFile("dbtest.csv");

        // This is "sort of" pushing out information to all the observers
        for (int i=0; i<10; i++) {

            // simulated subject data change
            stockGenerator();
            weatherGenerator();

            // update the news
            String temp = "";
            temp += String.format("TEMP %d PREC %d%% AIR %d %n", temperature, precipitation, airQuality);
            temp += String.format("DOW %.2f S&P %.2f 3M %.2f Microsoft %.2f %n", dow, snp, mmm, msft);
            news.redraw(temp);

            // update the database
            db.addData("and another");
         
            // update the stock watcher 
            System.out.printf("DOW %.2f S&P %.2f 3M %.2f Microsoft %.2f %n", dow, snp, mmm, msft);

            try {
                Thread.sleep(600);
            } catch (Exception e) {
            }
        }
    }

    // _____________________________________________________________________________
    // _____________________________________________________________________________

    public static void stockGenerator() {
        // Generate some random stock data

        double randDouble;

        // dow and snp can fluctuate in the range of 0 to 5% (+/-)
        // 50/50 chance of the index changing at this time

        if (random.nextDouble() < .50) {
            // change dow
            randDouble = random.nextDouble()*5.0/100;
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                randDouble *= -1;
            }
            dow = dow + randDouble*dow;
        }

        if (random.nextDouble() < .50) {
            // change snp
            randDouble = random.nextDouble()*5.0/100;
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                randDouble *= -1;
            }
            snp = snp + randDouble*snp;
        }

        // stocks can fluctuation in the range of 0 to 2% (+/-)
        // 70/30 chance of 3M changing at this time
        if (random.nextDouble() < .30) {
            // change 3M stock price
            randDouble = random.nextDouble()*2.0/100;
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                randDouble *= -1;
            }
            mmm = mmm + randDouble*mmm;        }

        // stocks can fluctuation in the range of 0 to 2%
        // 60/40 chance of 3M changing at this time
        if (random.nextDouble() < .40) {
            // change Microsoft stock price
            randDouble = random.nextDouble()*2.0/100;
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                randDouble *= -1;
            }
            msft = msft + randDouble*msft;        }

    }

    // _____________________________________________________________________________
    // _____________________________________________________________________________

    public static void weatherGenerator() {
        // Generate some random weather data
        // temp, precip, air

        int randInteger;
        double randDouble;

        // temp can fluctuate in the range of -1 to 1 degree
        // 80/20 chance of the temp changing at this time

        if (random.nextDouble() < .20) {
            // change temp
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                temperature = temperature + 1;
            } else {
                temperature = temperature - 1;
            }
        }

        // chance of precip can fluctuate in the range of 0 to 5% (+/-)
        // 60/40 chance of the temp changing at this time

        if (random.nextDouble() < .40) {
            // change precip
            randInteger = random.nextInt(5);
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                precipitation = precipitation - randInteger;
                if (precipitation<0) {
                    precipitation = 0;
                }
            } else {
                precipitation = precipitation + randInteger;
                if (precipitation > 100) {
                    precipitation = 100;
                }
            }
        }

        // chance of air quality index can fluctuate in the range of 0 to 1 (+/-)
        // 90/10 chance of the temp changing at this time

        if (random.nextDouble() < .10) {
            // change air quality index
            randInteger = random.nextInt(2);
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                airQuality = airQuality - randInteger;
                if (airQuality < 0) {
                    airQuality = 0;
                }
            } else {
                airQuality = airQuality + randInteger;
                if (airQuality > 100) {
                    airQuality = 100;
                }
            }
        }
        

        if (random.nextDouble() < .50) {
            // change snp
            randDouble = random.nextDouble()*5.0/100;
            if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
                randDouble *= -1;
            }
            snp = snp + randDouble*snp;
        }
    }
}
