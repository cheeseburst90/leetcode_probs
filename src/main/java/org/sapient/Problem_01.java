package org.sapient;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Log4j2
public class Problem_01 {

    public static void check01() {
        var employee01 = Employee.builder()
                .name("girish")
                .salary(new BigDecimal("20000"))
                .oracleId("1234")
                .certifications(Arrays.asList(Certification.builder().certId(123).certName("java").certCost(10000).isReimbursed(false).build(),
                        Certification.builder().certId(456).certName("CKAD").certCost(15000).isReimbursed(true).build(),
                        Certification.builder().certId(789).certName("GCP").certCost(50000).isReimbursed(false).build(),
                        Certification.builder().certId(145).certName("AZURE").certCost(12000).isReimbursed(false).build()))
                .build();

        var employee02 = Employee.builder()
                .name("bharath")
                .salary(new BigDecimal("800000"))
                .oracleId("4567")
                .certifications(Arrays.asList(Certification.builder().certId(123).certName("java").certCost(10000).isReimbursed(true).build(),
                        Certification.builder().certId(456).certName("CKAD").certCost(15000).isReimbursed(false).build(),
                        Certification.builder().certId(789).certName("GCP").certCost(50000).isReimbursed(true).build(),
                        Certification.builder().certId(145).certName("AZURE").certCost(12000).isReimbursed(true).build()))
                .build();

        var employee03 = Employee.builder()
                .name("sevenhills")
                .salary(new BigDecimal("20000"))
                .oracleId("78945")
                .certifications(Arrays.asList(Certification.builder().certId(123).certName("java").certCost(10000).isReimbursed(true).build(),
                        Certification.builder().certId(456).certName("CKAD").certCost(15000).isReimbursed(true).build(),
                        Certification.builder().certId(789).certName("GCP").certCost(50000).isReimbursed(true).build(),
                        Certification.builder().certId(145).certName("AZURE").certCost(12000).isReimbursed(true).build()))
                .build();

        var employee04 = Employee.builder()
                .name("alia")
                .salary(new BigDecimal("20000"))
                .oracleId("78454")
                .certifications(Arrays.asList(Certification.builder().certId(123).certName("java").certCost(10000).isReimbursed(false).build(),
                        Certification.builder().certId(456).certName("CKAD").certCost(15000).isReimbursed(false).build(),
                        Certification.builder().certId(789).certName("GCP").certCost(50000).isReimbursed(false).build(),
                        Certification.builder().certId(145).certName("AZURE").certCost(12000).isReimbursed(false).build()))
                .build();

        var employee05 = Employee.builder()
                .name("krish")
                .salary(new BigDecimal("2000000"))
                .oracleId("48585")
                .certifications(Arrays.asList(Certification.builder().certId(123).certName("java").certCost(10000).isReimbursed(false).build(),
                        Certification.builder().certId(456).certName("CKAD").certCost(15000).isReimbursed(true).build(),
                        Certification.builder().certId(789).certName("GCP").certCost(50000).isReimbursed(true).build(),
                        Certification.builder().certId(145).certName("AZURE").certCost(12000).isReimbursed(true).build()))
                .build();

        var employee06 = Employee.builder()
                .name("goel")
                .salary(new BigDecimal("2000000000"))
                .oracleId("78945")
                .certifications(Arrays.asList(Certification.builder().certId(123).certName("java").certCost(10001).isReimbursed(true).build(),
                        Certification.builder().certId(456).certName("CKAD").certCost(15000).isReimbursed(false).build(),
                        Certification.builder().certId(789).certName("GCP").certCost(50000).isReimbursed(false).build(),
                        Certification.builder().certId(145).certName("AZURE").certCost(12000).isReimbursed(false).build()))
                .build();
        var employees = new ArrayList<Employee>();
        employees.add(employee01);
        employees.add(employee02);
        employees.add(employee03);
        employees.add(employee04);
        employees.add(employee05);
        employees.add(employee06);
        //log.info("my employees: {}", employees);
        //get employees who has done certification which has cost in between 10000 and 20000
        List<Certification> certList = employees.parallelStream().flatMap(emp->emp.getCertifications().stream()).collect(Collectors.toList());
        log.info("certList: {}", certList);
        var certNewList = certList.parallelStream().filter(cert->cert.getCertCost()==10000).collect(Collectors.toList());
        Predicate<Certification> certPredicate = cert->cert.getCertCost()==10000;
        log.info("certNewList: {}",certNewList);
        var check_01List = employees.stream()
                .filter(emp->emp.getCertifications().stream().anyMatch(certPredicate))
                .collect(Collectors.toList());
        log.info("check_01List: {}", check_01List);
        //filter the inner list and remove based on condition and shud give the outer list.
        var filteredList = employees.parallelStream().map(e->e.getCertifications().parallelStream().filter(certPredicate).collect(Collectors.toList())).collect(Collectors.toList());
        log.info("filteredList: {}", filteredList);
    }

    public static void main(String[] args) {
        /*var listOfPlayers = getPlayers();
        log.debug("listOfPlayers: {}",listOfPlayers);
        Checker checker = new Checker();
        //Collections.sort(listOfPlayers,checker);
        //java 8 sorting
        listOfPlayers.sort((o1, o2) -> {
            int comp = Integer.compare(o1.getScore(),o2.getScore());
            log.trace("o1 here is: {}", o1);
            log.trace("o2 here is: {}", o2);
            log.trace("comp here is: {}", comp);
            if(comp==0){
                return o2.getPlayerName().compareTo(o1.getPlayerName());
            }
            return comp;
        });
        log.info("after sorted listOfPlayers: {}",listOfPlayers);*/
        check01();
    }

    public static List<Player> getPlayers() {
        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(Player.builder().playerName("MS.Dhoni").score(200).build());
        listOfPlayers.add(Player.builder().playerName("Virat Kholi").score(190).build());
        listOfPlayers.add(Player.builder().playerName("Sachin").score(198).build());
        listOfPlayers.add(Player.builder().playerName("abhishek").score(198).build());
        return listOfPlayers;
    }
}
