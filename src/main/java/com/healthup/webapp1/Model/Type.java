package com.healthup.webapp1.Model;

public enum Type
{
    PERSON("Person"),
    CITY("City"),
    STATE_OR_PROVINCE("State_or_province"),
    COUNTRY("Country"),
    EMAIL("Email"),
    TITLE("Title"),
    DURATION("Duration"),
    CAUSE_OF_DEATH("Cause_of_death"),
    MISC("Misc");

    private String type;
    //passing string as an argument thus a const. is required
    Type(String type)
    {
           this.type = type;
    }

    public String GetName()   // method to get the type name
    {
        return type;
    }

    public String getName()
    {
        return type;
    }
}
