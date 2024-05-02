package com.masai.user.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrors {
   private LocalDateTime timeStamp;
   private String msg;
   private String details;
   
}
