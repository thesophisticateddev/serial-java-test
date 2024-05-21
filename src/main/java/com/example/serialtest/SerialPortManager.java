package com.example.serialtest;

import java.util.List;

public interface SerialPortManager {

   List<String> getListOfPorts();

   void setPort(String port);
}
