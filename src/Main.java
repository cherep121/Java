import lsp.*;
import ocp.*;
import srp.ReportManager;
import isp.*;
import dip.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ---------- SRP Demo ----------
        System.out.println("=== SRP Demo ===");
        ReportManager manager = new ReportManager(List.of(5, 10, 15, 20));
        manager.generateReport();

        // ---------- OCP Demo ----------
        System.out.println("\n=== OCP Demo ===");
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Regular: " + calculator.calculateDiscount(new RegularDiscount(), 1000));
        System.out.println("VIP: " + calculator.calculateDiscount(new VipDiscount(), 1000));
        System.out.println("Super VIP: " + calculator.calculateDiscount(new SuperVipDiscount(), 1000));
        System.out.println("Student: " + calculator.calculateDiscount(new StudentDiscount(), 1000));

        // ---------- LSP Demo ----------
        System.out.println("\n=== LSP Demo ===");
        displayFlyingBird(new Sparrow());
        displayNonFlyingBird(new Penguin());

        System.out.println("\n=== All birds eating ===");
        displayBirdEating(new Sparrow());
        displayBirdEating(new Penguin());

        // ---------- ISP Demo ----------
        System.out.println("\n=== ISP Demo ===");
        Printer oldPrinter = new OldPrinter();
        oldPrinter.print("Отчёт за неделю");

        MultiFunctionMachine modernPrinter = new ModernPrinter();
        modernPrinter.print("Документ");
        modernPrinter.scan("Фотография");
        modernPrinter.fax("Договор");

        // ---------- DIP Demo ----------
        System.out.println("\n=== DIP Demo ===");
        MessageSender emailSender = new EmailSender();
        NotificationService emailService = new NotificationService(emailSender);
        emailService.send("Ваш заказ готов к выдаче!");

        MessageSender smsSender = new SmsSender();
        NotificationService smsService = new NotificationService(smsSender);
        smsService.send("Ваш код подтверждения: 123456");
    }

    // LSP-совместимые методы
    public static void displayFlyingBird(FlyingBird bird) {
        bird.eat();
        bird.fly();
    }

    public static void displayNonFlyingBird(NonFlyingBird bird) {
        bird.eat();
        bird.walk();
        if (bird instanceof Penguin penguin) {
            penguin.swim();
        }
    }

    public static void displayBirdEating(Bird bird) {
        bird.eat();
    }
}