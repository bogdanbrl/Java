package com.bogdan.encapsulation;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        System.out.println("Initial pages printed: "+ printer.getPrintedPages());
        int pagesPrinted = printer.printPages(4);
        System.out.println("There was "+pagesPrinted+
                " printed pages. New total print count for printer is "+printer.getPrintedPages());
        int pagesPrinted2 = printer.printPages(7);
        System.out.println("There was "+pagesPrinted2+
                " printed pages. New total print count for printer is "+printer.getPrintedPages());


        System.out.println("\n\nSecond printer\n");
        Printer printer2 = new Printer(50, false);
        System.out.println("Initial pages printed: "+ printer2.getPrintedPages());
        int pagesPrinted3 = printer2.printPages(4);
        System.out.println("There was "+pagesPrinted3+
                " printed pages. New total print count for printer is "+printer2.getPrintedPages());

    }
}
