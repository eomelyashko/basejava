package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;

import static ru.javawebinar.basejava.model.ContactsType.*;
import static ru.javawebinar.basejava.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.addContacts(PHONE, new Contacts("+7(921) 855-0482"));
        resume.addContacts(SKYPE, new Contacts("grigory.kislin", "skype:grigory.kislin"));
        resume.addContacts(EMAIL, new Contacts("gkislin@yandex.ru"));
        resume.addContacts(LINKEDIN, new Contacts("LinkedIn", "https://www.linkedin.com/in/gkislin"));
        resume.addContacts(GITHUB, new Contacts("GitHub", "https://github.com/gkislin"));
        resume.addContacts(STACKOVERFLOW, new Contacts("Stackoverflow", "https://stackoverflow.com/users/548473"));
        resume.addProfile(PERSONAL, new Profile("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX).  Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников."));
        resume.addProfile(OBJECTIVE, new Profile("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSkills(ACHIEVEMENT, new Skills("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке:" +
                        "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера."));
        resume.addSkills(QUALIFICATIONS, new Skills("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle"));
        resume.addPositions(EXPERIENCE, new Position("Java Online Projects", "Автор проекта.\nСоздание, организация и проведение Java онлайн проектов и стажировок.",
                LocalDate.of(2013, 10, 1), null, "http://javaops.ru/"),
                new Position("Wrike", "Старший разработчик (backend)\nПроектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1), "https://www.wrike.com/"),
                new Position("RIT Center", "Java архитектор\nОрганизация процесса разработки системы ERP для разных окружений: релизная политика, " +
                "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online " +
                "редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1)));
        resume.addPositions(EDUCATION, new Position("Coursera", "\"Functional Programming Principles in Scala\" by Martin Odersky",
                LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "https://www.coursera.org/course/progfun"),
                new Position("Luxoft", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1), "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"),
                new Position("Siemens AG", "3 месяца обучения мобильным IN сетям (Берлин)",
                LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1), "http://www.siemens.ru/"));
        System.out.println(resume);
    }
}
