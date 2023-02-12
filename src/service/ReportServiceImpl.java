package service;

import model.Product;
import model.Sell;
import service.interfaces.ReportService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Odilov_Zafarjon
 * @link https://t.me/zafarzhon_odilov
 */
public enum ReportServiceImpl implements ReportService {
    REPORT_SERVICE;

    @Override
    public double sumOfDay(LocalDate localDate) {
        double sum = 0;
        Sell[] sells = SellServiceImpl.SELL_SERVICE.getSellList();
        for (Sell sell : sells) {
            if (sell == null) continue;
            if (sell.getLocalDateTime().toLocalDate().equals(localDate)) {
                Product product = sell.getProduct();
                sum += product.getPrice() * product.getCount();
            }
        }
        return sum;
    }

    @Override
    public double sumOfLastHour(LocalDateTime localDateTime) {
        double sum = 0;
        Sell[] sells = SellServiceImpl.SELL_SERVICE.getSellList();
        for (Sell sell : sells) {
            if (sell == null) continue;
            if (sell.getLocalDateTime().isBefore(localDateTime) && sell.getLocalDateTime().isAfter(localDateTime.minusHours(1))) {
                Product product = sell.getProduct();
                sum += product.getPrice() * product.getCount();
            }
        }
        return sum;
    }

    @Override
    public double sumOfWeekYear(int weekOfYear, int year) {
        double sum = 0;
        Sell[] sells = SellServiceImpl.SELL_SERVICE.getSellList();
        for (Sell sell : sells) {
            if (sell == null) continue;
            if (sell.getLocalDateTime().getYear() == year && ((sell.getLocalDateTime().getDayOfYear() - 1) / 7) + 1 == weekOfYear) {
                Product product = sell.getProduct();
                sum += product.getPrice() * product.getCount();
            }
        }
        return sum;
    }

    @Override
    public double sumOfMonth(int monthYear, int year) {
        double sum = 0;
        Sell[] sells = SellServiceImpl.SELL_SERVICE.getSellList();
        for (Sell sell : sells) {
            if (sell == null) continue;
            if (sell.getLocalDateTime().getYear() == year && sell.getLocalDateTime().getMonthValue() + 1 == monthYear) {
                Product product = sell.getProduct();
                sum += product.getPrice() * product.getCount();
            }
        }
        return sum;
    }

    @Override
    public double sum(LocalDate from, LocalDate to) {
        double sum = 0;
        Sell[] sells = SellServiceImpl.SELL_SERVICE.getSellList();
        for (Sell sell : sells) {
            if (sell == null) continue;
            LocalDate sellDate = sell.getLocalDateTime().toLocalDate();
            if (sellDate.isAfter(from) && sellDate.isBefore(to)) {
                Product product = sell.getProduct();
                sum += product.getPrice() * product.getCount();
            }
        }
        return sum;
    }

    @Override
    public double sumFromToHour(LocalDateTime from, LocalDateTime to) {
        double sum = 0;
        Sell[] sells = SellServiceImpl.SELL_SERVICE.getSellList();
        for (Sell sell : sells) {
            if (sell == null) continue;
            LocalDateTime sellDate = sell.getLocalDateTime();
            if (sellDate.isAfter(from) && sellDate.isBefore(to)) {
                Product product = sell.getProduct();
                sum += product.getPrice() * product.getCount();
            }
        }
        return sum;
    }

    @Override
    public double sumOfDay(LocalDate localDate, String zoneId) {
//        localDate = LocalDate.ofInstant(Instant.from(localDate),ZoneId.of(zoneId));
//        double sum = 0;
//        Sell[] sells = SellServiceImpl.SELL_SERVICE.getSellList();
//        for (Sell sell : sells) {
//            if (sell == null) continue;
//            LocalDate sellDate = sell.getLocalDateTime().toLocalDate();
//            if (sellDate.equals(localDate)){
//                Product product = sell.getProduct();
//                sum += product.getPrice() * product.getCount();
//            }
//        }
        return 0;
    }
}
