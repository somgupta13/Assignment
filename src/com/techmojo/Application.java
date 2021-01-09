package com.techmojo;

import com.techmojo.exception.CustomException;
import com.techmojo.service.TransactionService;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class Application {
    private static TransactionService transactionService =  new TransactionService();
    public static void main(String[] args) {
        System.out.println("Application started");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try{
                System.out.println("Please Choose option");
                System.out.println("1 for transaction in entry");
                System.out.println("2 for get average Time");
                System.out.println("3 for exit");

                int input = Integer.parseInt(br.readLine().trim());
                if(input==1){
                    System.out.println("Please give full transaction");
                    String s[] = br.readLine().trim().split(",");
                    transactionService.saveTransaction(s);
                    System.out.println("Transaction saved");
                }else if( input==2 ){
                    System.out.println("Average Time in millisecond :" +transactionService.getAverageTime());
                }else if( input==3 ){
                    System.out.println("List of All transactions");
                    transactionService.getAllTransactions();
                    System.out.println("Application closed ...");
                    System.exit(0);
                }else {
                    throw new CustomException("Valid input");
                }

            }catch (Exception e){
                System.out.println("Please give valid input");
            }

        }


    }
}
