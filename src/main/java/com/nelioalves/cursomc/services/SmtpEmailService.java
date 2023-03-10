package com.nelioalves.cursomc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SmtpEmailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    JavaMailSender javaMailSender;
    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage message) {
        LOG.info("Enviando email...");
        mailSender.send(message);
        LOG.info("Email enviado");
    }

    @Override
    public void sendHtmlEmail(MimeMessage message) {
        LOG.info("Enviando email...");
        javaMailSender.send(message);
        LOG.info("Email enviado");
    }
}
