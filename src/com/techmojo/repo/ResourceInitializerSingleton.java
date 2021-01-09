package com.techmojo.repo;

import com.techmojo.model.TimeEntity;
import com.techmojo.util.Utils;

import java.util.Date;
import java.util.HashMap;

// it is a Singleton class for saving the Resources
public class ResourceInitializerSingleton {

    private static ResourceInitializerSingleton instance;
    //Volatile Hash Map
    private HashMap<String, Date> vhm;

    //Static Hash Map
    private HashMap<String, TimeEntity> shm;
    private double avgTime;
    private int totalTransaction;

    private ResourceInitializerSingleton(){
        vhm = new HashMap<>();
        shm = new HashMap<>();
        avgTime=0;
        totalTransaction=0;
    }

    public void saveData(String s[]) {
        Date date= Utils.convertToDate(s);
        if(s[3].trim().equals("start")){
            vhm.put(s[0], date);
            shm.put(s[0],new TimeEntity().setStartTime(date).setTid(s[0]));
        }else{
            Date start = vhm.get(s[0]);
            shm.get(s[0]).setEndTime(date);
            long epocStart = start.getTime();
            long epocEnd = date.getTime();
            double totalTime = (avgTime*totalTransaction);
            double currentTotalTime = totalTime+Math.abs(epocEnd-epocStart);
            totalTransaction++;
            avgTime = currentTotalTime/totalTransaction;
            vhm.remove(s[0]);
//                System.out.println(avgTime);
        }
    }

    // for getting instance
    public static ResourceInitializerSingleton getInstance() {
        if (instance == null) {
            synchronized (ResourceInitializerSingleton.class) {
                if (instance == null) {
                    instance = new ResourceInitializerSingleton();
                }
            }
        }
        return instance;
    }


    public double getAvgTime() {
        return avgTime;
    }


    public HashMap<String, TimeEntity> getShm() {
        return (HashMap<String, TimeEntity>) shm.clone();
    }
}
