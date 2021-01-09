package com.techmojo.service;

import com.techmojo.model.TimeEntity;
import com.techmojo.repo.ResourceInitializerSingleton;

import java.util.HashMap;
import java.util.Objects;

public class TransactionService {
    private ResourceInitializerSingleton resourceInitializerSingleton
            = ResourceInitializerSingleton.getInstance();

    public void saveTransaction(String s[]){
        resourceInitializerSingleton.saveData(s);
    }

    public double getAverageTime(){
      return resourceInitializerSingleton.getAvgTime();
    }

    public void getAllTransactions(){
        HashMap<String, TimeEntity> shm = resourceInitializerSingleton.getShm();
        for(String key : shm.keySet()){
            TimeEntity timeEntity = shm.get(key);
            System.out.print(key+" StartTime: "+ timeEntity.getStartTime().toString());
            if(!Objects.isNull(timeEntity.getEndTime()))
                System.out.println(" EndTime: "+ timeEntity.getEndTime().toString());
            else
                System.out.println(" EndTime: Transaction in progress");
        }
    }
}
