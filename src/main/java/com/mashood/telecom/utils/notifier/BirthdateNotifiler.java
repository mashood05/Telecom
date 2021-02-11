package com.mashood.telecom.utils.notifier;

import com.mashood.telecom.domain.Customer;
import com.mashood.telecom.service.CustomerReadPlateformService;
import com.mashood.telecom.service.email.EmailSender;
import com.mashood.telecom.utils.reporting.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Component
public class BirthdateNotifiler implements ImportentDateNotifier{
    private Logger logger = LoggerFactory.getLogger(BirthdateNotifiler.class);

    // days and message are beign set from the application.propertie file
    @Value("${birthdate.notification.day}")
    private int days;
    @Value("${birthdate.notification.message}")
    private String message;
    private final EmailSender emailSender;
    private final CustomerReadPlateformService customerReadPlateformService;
    private Report report;
    private List<Customer> customerHolder;
    private Date localDate;

    public BirthdateNotifiler(EmailSender emailSender, CustomerReadPlateformService customerReadPlateformService, Report report) {
        this.emailSender = emailSender;
        this.customerReadPlateformService = customerReadPlateformService;
        this.report = report;
        this.customerHolder = new ArrayList<>();
        this.localDate = new Date(Calendar.getInstance().getTime().getTime());;
    }

    @Override
    public String notification(String to,String name) {
        this.emailSender.send(to,buildEmail(name));
        return "Birthday Email Send";
    }

    // this function will trigger every 24 hour to check the customer birthdays and also the current day birthdays
    //@Scheduled(cron = "0 0 23 * * *")
    @Scheduled(fixedRate = 20000)
    public void checkBirthDateInterval() throws InterruptedException{
        Iterable<Customer> customers = this.customerReadPlateformService.getAllCustomer();
        customers.forEach(this::calculateBirthday);

        // genrateReporting is for daily customer reporting
        this.report.genrateReport(customerHolder, LocalDate.now(), LocalTime.now());
        this.customerHolder = new ArrayList<>();
        logger.info("Birthday: Checking daily birthdays");
    }

    // helper function to calculate current and advance birthday
    private void calculateBirthday(Customer customer){

        Date customerBirthdate = customer.getDate();
        Date localDate = this.localDate;
        Date futureDate = addDays(localDate,days);

        Calendar cal = Calendar.getInstance();
        cal.setTime(customerBirthdate);
        int customerMonth = cal.get(Calendar.MONTH)+1;
        int customerDay = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(futureDate);
        int futureDateMonth = cal.get(Calendar.MONTH)+1;
        int futureDateDay = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(localDate);
        int localDateMonth = cal.get(Calendar.MONTH)+1;
        int localDateDay = cal.get(Calendar.DAY_OF_MONTH);


        // check for checking the advance birthday
        if (customerMonth==futureDateMonth && customerDay==futureDateDay){
            this.notification(customer.getEmail(),customer.getName());

            customerHolder.add(customer);
            logger.info("Happy Birthday: "+ customer.getName());
        }

        // check for checking the current day birthday
        if (customerMonth==localDateMonth && customerDay==localDateDay){
            customerHolder.add(customer);
        }

    }

    // helper function for add days to any given date
    private static Date addDays(Date date, int days) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());

    }

    // this function will return a html to send birthday greetings
    private String buildEmail(String name) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Happy Birthday</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">"+message+"</p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> </p></blockquote>\n Thank You . <p>Evamp & Saanga </p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }

}
