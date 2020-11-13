package edu.ejb;

public interface EJBComponent {

    boolean login (String l, String p);
    String getMessage () throws Exception;
}
