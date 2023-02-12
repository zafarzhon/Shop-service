import model.Product;
import model.Sell;
import service.ProductServiceImpl;
import service.ReportServiceImpl;
import service.SellServiceImpl;
import service.interfaces.ProductService;
import service.interfaces.ReportService;
import service.interfaces.SellService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ApplicationApp {
    static ProductService productService = ProductServiceImpl.PRODUCT_SERVICE;
    static SellService sellService = SellServiceImpl.SELL_SERVICE;

    static ReportService reportService = ReportServiceImpl.REPORT_SERVICE;

    public static void main(String[] args) {
        // for test
        {
            productService.addProduct("coca cola", 20, 20000);
            productService.addProduct("fanta", 20, 20000);
            productService.addProduct("pepsi", 20, 20000);
            productService.addProduct("sprite", 20, 20000);
            productService.addProduct("pen", 20, 20000);
        }

        Scanner sc = new Scanner(System.in);
        int command = -1;
        while (command != 0) {
            System.out.println(
                    """
                            1 => Product service
                            2 => Sell service
                            3 => Report service
                            0 => Exit in program""");
            System.out.print("Enter command: ");
            command = Integer.parseInt(sc.nextLine());
            space();
            int temp = -1;
            switch (command) {
                case 1:
                    while (temp != 0) {
                        System.out.println(
                                """
                                        1 => add product
                                        2 => change product
                                        3 => delete product
                                        4 => view products
                                        0 => close"""
                        );
                        space();
                        System.out.print("Enter command: ");
                        temp = Integer.parseInt(sc.nextLine());
                        switch (temp) {
                            case 1 -> addProduct(sc);
                            case 2 -> updateProduct(sc);
                            case 3 -> deleteProduct(sc);
                            case 4 -> printProducts();
                            default -> System.out.print(temp == 0 ? "" : "non-existent command\n");
                        }
                    }
                    break;
                case 2:
                    while (temp != 0) {
                        System.out.println(
                                """
                                        1 => sell product
                                        2 => edit sell
                                        3 => delete sell
                                        4 => view sell
                                        0 => close"""
                        );
                        space();
                        System.out.print("Enter command: ");
                        temp = Integer.parseInt(sc.nextLine());
                        switch (temp) {
                            case 1 -> sellProduct(sc);
                            case 2 -> updateSell(sc);
                            case 3 -> deleteSell(sc);
                            case 4 -> printSells();
                            default -> System.out.print(temp == 0 ? "" : "non-existent command\n");
                        }
                    }
                    break;
                case 3:
                    while (temp != 0) {
                        System.out.println(
                                """
                                        1 => report by today
                                        2 => report last hour
                                        3 => report by week of year
                                        4 => report by month and year
                                        0 => close"""
                        );
                        space();
                        System.out.print("Enter command: ");
                        temp = Integer.parseInt(sc.nextLine());
                        switch (temp) {
                            case 1 -> reportToday();
                            case 2 -> reportLastHour();
                            case 3 -> reportByWeekOfYear(sc);
                            case 4 -> reportByMonthOfYear(sc);

                            default -> System.out.print(temp == 0 ? "" : "non-existent command\n");
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("non-existent command");
            }

        }

    }

    // for product service
    public static void addProduct(Scanner sc) {
        System.out.print("Enter name product: ");
        String name = sc.nextLine();
        System.out.print("Enter amount product: ");
        int count = Integer.parseInt(sc.nextLine());
        System.out.print("Enter price product: ");
        double price = Double.parseDouble(sc.nextLine());
        productService.addProduct(name, count, price);
    }

    public static void updateProduct(Scanner sc) {
        printProducts();
        System.out.print("Enter name product: ");
        String name = sc.nextLine();
        System.out.print("Enter amount product: ");
        int count = Integer.parseInt(sc.nextLine());
        System.out.print("Enter price product: ");
        double price = Double.parseDouble(sc.nextLine());
        productService.updateProduct(name, count, price);
    }

    public static void deleteProduct(Scanner sc) {
        printProducts();
        System.out.print("Enter name product: ");
        String name = sc.nextLine();
        productService.deleteProduct(name);
    }

    public static void printProducts() {
        space();
        Product[] products = productService.getProductList();
        int i = 0;
        for (Product product : products) {
            if (product == null) continue;
            System.out.println(++i + ". " + product);
        }
        space();
    }

    // for sell service

    public static void sellProduct(Scanner sc) {
        printProducts();
        System.out.print("Enter name product: ");
        String name = sc.nextLine();
        System.out.print("Enter amount product: ");
        int count = Integer.parseInt(sc.nextLine());
        sellService.sell(name, count);
    }

    public static void updateSell(Scanner sc) {
        printSells();
        System.out.print("Enter sell id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter amount product: ");
        int count = Integer.parseInt(sc.nextLine());
        sellService.editSell(id, count);

    }

    public static void deleteSell(Scanner sc) {
        printSells();
        System.out.print("Enter sell id: ");
        int id = Integer.parseInt(sc.nextLine());
        sellService.deleteSell(id);
    }

    public static void printSells() {
        space();
        Sell[] sells = sellService.getSellList();
        int i = 0;
        for (Sell sell : sells) {
            if (sell == null) continue;
            System.out.println(++i + ". " + sell);
        }
        space();
    }

    // for report service

    public static void reportToday() {
        System.out.println(reportService.sumOfDay(LocalDate.now()));
    }

    public static void reportLastHour() {
        System.out.println(reportService.sumOfLastHour(LocalDateTime.now()));
    }

    //    """
//                                        1 => report by today
//                                        2 => report last hour
//                                        3 => report by week of year
//                                        4 => report by month and year
//                                        0 => close"""
    public static void reportByWeekOfYear(Scanner sc) {
        System.out.print("Enter week of year");
        int weekOfYear = Integer.parseInt(sc.nextLine());
        System.out.print("Enter year");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println(reportService.sumOfWeekYear(weekOfYear, year));

    }

    public static void reportByMonthOfYear(Scanner sc) {
        System.out.print("Enter month number [1:12] of year");
        int monthOfYear = Integer.parseInt(sc.nextLine());
        System.out.print("Enter year");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println(reportService.sumOfMonth(monthOfYear, year));
    }
    public static void reportByDateFromTo(Scanner sc){
        System.out.print("Enter day of month");
        int day1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter month number [1:12] of year");
        int monthOfYear1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter year");
        int year1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter day of month");
        int day2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter month number [1:12] of year");
        int monthOfYear2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter year");
        int year2 = Integer.parseInt(sc.nextLine());
        System.out.println(reportService.sum(LocalDate.of(year1,monthOfYear1,day1),LocalDate.of(year2,monthOfYear2,day2)));
    }
    public static void reportByHoursFromTo(Scanner sc){
        System.out.print("Enter day of month");
        int day1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter month number [1:12] of year");
        int monthOfYear1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter year");
        int year1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter hour");
        int hour1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter minute");
        int minutes1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter day of month");
        int day2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter month number [1:12] of year");
        int monthOfYear2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter year");
        int year2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter hour");
        int hour2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter minute");
        int minutes2 = Integer.parseInt(sc.nextLine());
        System.out.println(reportService.sumFromToHour(LocalDateTime.of(year1,monthOfYear1,day1,hour1,minutes1),LocalDateTime.of(year2,monthOfYear2,day2,hour2,minutes2)));
    }
    private static void space() {
        System.out.println("--------------------------------------------------------------------------------");
    }


}
