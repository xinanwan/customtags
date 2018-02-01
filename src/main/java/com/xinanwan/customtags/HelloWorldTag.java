package com.xinanwan.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HelloWorldTag extends SimpleTagSupport {

    LocalDateTime localDateTime = LocalDateTime.now();
    int hour = localDateTime.getHour();
    LocalDate localDate = localDateTime.toLocalDate();
    LocalDate groundhogDay = LocalDate.of(2018, 2, 2);

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.print("Hello Ent Java Class");

        if ( hour < 12 ) {
            out.print("<br />Good morning!");
        } else if (hour == 12) {
            out.print("<br />Happy Lunchtime!");
        } else if (hour > 12 && hour < 18) {
            out.print("/nGood afternoon!");
        } else if (hour >= 18) {
            out.print("<br />Good Evening!");
        }

        if (localDate.equals(groundhogDay)) {
            out.print("<br />Happy Groundhog Day!");
        }

    }
}
