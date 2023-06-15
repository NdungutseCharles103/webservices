package rw.ac.rca.webservices.utils;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Random {
    public static void main(String[] args) {
        String dateString = "2021-03-02";
        LocalDate date = LocalDate.parse(dateString);
        LocalDateTime localDateTime = date.atStartOfDay();

        System.out.println(localDateTime);
    }
}
