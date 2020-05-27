package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static ru.javawebinar.basejava.model.ContactsType.*;
import static ru.javawebinar.basejava.model.SectionType.*;

public class ResumeTestData {
    public static final String UUID_0 = "uuid0";
    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";

    public static void main(String[] args) {
        Resume resume = new Resume(UUID.randomUUID().toString(), "Григорий Кислин");
        resume.addContacts(PHONE, "+7(921) 855-0482");
        resume.addContacts(SKYPE, "grigory.kislin");
        resume.addContacts(MAIL, "gkislin@yandex.ru");
        resume.addContacts(LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.addContacts(GITHUB, "https://github.com/gkislin");
        resume.addContacts(STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.addSection(PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.addSection(OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSection(ACHIEVEMENT, new Skills("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке:" +
                        "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера."));
        resume.addSection(QUALIFICATIONS, new Skills("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle"));
        resume.addSection(EXPERIENCE, new PositionList(new Position("Java Online Projects", "http://javaops.ru/", new Position.Experience("Автор проекта.","Создание, организация и проведение Java онлайн проектов и стажировок.", 2013, Month.OCTOBER)),
                new Position("Wrike", "https://www.wrike.com/", new Position.Experience("Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                        "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                        2014, Month.OCTOBER, 2016, Month.JANUARY)),
                new Position("RIT Center", "",new Position.Experience("Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                        "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                        "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online " +
                        "редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                        2012, Month.APRIL, 2014, Month.OCTOBER))));
        resume.addSection(EDUCATION, new PositionList(new Position("Coursera", "https://www.coursera.org/course/progfun", new Position.Experience("\"Functional Programming Principles in Scala\" by Martin Odersky", "",
                        LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1))),
                new Position("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", new Position.Experience("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "",
                        LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1))),
                new Position("Siemens AG", "http://www.siemens.ru/", new Position.Experience("3 месяца обучения мобильным IN сетям (Берлин)", "",
                        LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1)))));
        System.out.println(resume);
    }

    public static Resume getResume(String uuid, String fullName) {
        Resume testResume = new Resume(uuid, fullName);
        testResume.addContacts(ContactsType.MAIL, "mail1@ya.ru");
        testResume.addContacts(ContactsType.PHONE, "11111");
        testResume.addContacts(ContactsType.SKYPE, "Skype");

        testResume.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        testResume.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        testResume.addSection(SectionType.ACHIEVEMENT, new Skills("Achivment11", "Achivment12", "Achivment13"));
        testResume.addSection(SectionType.QUALIFICATIONS, new Skills("Java", "SQL", "JavaScript"));
        testResume.addSection(SectionType.EXPERIENCE,
                new PositionList(
                        new Position("Organization11", "http://Organization11.ru",
                                new Position.Experience("position1", "content1", 2005, Month.JANUARY),
                                new Position.Experience("position2", "content2", 2001, Month.MARCH, 2005, Month.JANUARY))));
        testResume.addSection(SectionType.EXPERIENCE,
                new PositionList(
                        new Position("Organization2", "http://Organization2.ru",
                                new Position.Experience("position1", "content1", 2015, Month.JANUARY))));
        return testResume;
    }
}
