package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static ru.javawebinar.basejava.model.ContactsType.*;
import static ru.javawebinar.basejava.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        Map<Enum, Contacts> contactsMap = new HashMap<>();
        contactsMap.put(PHONE, new Contacts("+7(921) 855-0482"));
        contactsMap.put(SKYPE, new Contacts("grigory.kislin", "skype:grigory.kislin"));
        contactsMap.put(EMAIL, new Contacts("gkislin@yandex.ru"));
        contactsMap.put(OTHER, new Contacts("LinkedIn", "https://www.linkedin.com/in/gkislin"));
        contactsMap.put(OTHER, new Contacts("GitHub", "https://github.com/gkislin"));
        contactsMap.put(OTHER, new Contacts("Stackoverflow", "https://stackoverflow.com/users/548473"));
        resume.setContactsMap(contactsMap);
        Map<Enum, Section> sectionMap = new HashMap<>();
        sectionMap.put(PERSONAL, new Profile("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX).  Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников."));
        sectionMap.put(OBJECTIVE, new Profile("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        sectionMap.put(ACHIEVEMENT, new Skills("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке:" +
                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера."));
        sectionMap.put(QUALIFICATIONS, new Skills("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle"));
        sectionMap.put(EXPERIENCE, new Recommendations("Java Online Projects", "Автор проекта.\nСоздание, организация и проведение Java онлайн проектов и стажировок.",
                LocalDate.of(2013, 10, 0), null, "http://javaops.ru/"));
        sectionMap.put(EXPERIENCE, new Recommendations("Wrike", "Старший разработчик (backend)\nПроектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                LocalDate.of(2014, 10, 0), LocalDate.of(2016, 1, 0), "https://www.wrike.com/"));
        sectionMap.put(EXPERIENCE, new Recommendations("RIT Center", "Java архитектор\nОрганизация процесса разработки системы ERP для разных окружений: релизная политика, " +
                "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online " +
                "редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                LocalDate.of(2012, 4, 0), LocalDate.of(2014, 10, 0)));
        sectionMap.put(EDUCATION, new Recommendations("Coursera", "\"Functional Programming Principles in Scala\" by Martin Odersky",
                LocalDate.of(2013, 3, 0), LocalDate.of(2013, 5, 0), "https://www.coursera.org/course/progfun"));
        sectionMap.put(EDUCATION, new Recommendations("Luxoft", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                LocalDate.of(2011, 3, 0), LocalDate.of(2011, 4, 0), "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"));
        sectionMap.put(EDUCATION, new Recommendations("Siemens AG", "3 месяца обучения мобильным IN сетям (Берлин)",
                LocalDate.of(2005, 1, 0), LocalDate.of(2005, 4, 0), "http://www.siemens.ru/"));
        resume.setSectionMap(sectionMap);
    }
}
