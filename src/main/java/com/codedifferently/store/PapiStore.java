// This the package
package com.codedifferently.store;

//These are importing classes from the org.junit folder
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// This is a public class called PapiStore
public class PapiStore {
    // This is a private boolean called isStoreOpen
    private boolean isStoreOpen;
    //This is a private String array list of tabs
    private ArrayList<String> tabs;
    //This is a String Map it stores pairs of keys and values that can be looked up sing just the key
    Map<String, Double> owesPapiMoney;

    // These are constructors these set the initial state
    public PapiStore(){
        //Initial state for is Store Open
        this.isStoreOpen = false;
        //initial state for tabs
        this.tabs = new ArrayList();
        //Initial state for owesPapiMoney, it used the Hashmap to pull the value
        this.owesPapiMoney = new HashMap<>();
    }
    //
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        this.isStoreOpen = isOpen;
        this.tabs = tabsIn;
        this.owesPapiMoney = new HashMap<>();
    }

    public void closeStore(){

    }

    public void openStore(){
        this.isStoreOpen = true;
    }

    public boolean isStoreOpen() {
        return isStoreOpen;
    }

    // this public boolean checks to see if a tab can be used by checking two parameters
    public Boolean allowToUseTab(String name){
        Boolean response = false;
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
            response = true;
        return response;
    }
    // This private boolean checks to see if there is a balance due on an tab and if so how much.
    private boolean hasAnOverDueBalance(String name){
        if(!owesPapiMoney.containsKey(name))
            return false;
        Double money = owesPapiMoney.get(name);
        Boolean owes = false;
        if(money > 0.0)
            owes = true;
        return owes;
    }
    //This private boolean is checks to see if there is an active tab using an enhanced for loop
    private boolean hasAnActiveTab(String name){
        for (String tab : tabs){
            if (tab.equals(name))
                return true;
        }
        // This code returns false if an active tab is not found
        return false;
    }
    //This code will allow for a new tab to be opened
    public void createActiveTab(String name){
        this.tabs.add(name);
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
