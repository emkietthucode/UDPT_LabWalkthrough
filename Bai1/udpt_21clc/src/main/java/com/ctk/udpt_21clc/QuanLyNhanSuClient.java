package com.ctk.udpt_21clc;

import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
 
@FeignClient("QuanLyNhanSu") 
public interface QuanLyNhanSuClient { 
 
 @GetMapping(value = "/employee") 
 String LayThongTinNhanVien(); 
  
 @RequestMapping(value = "/add") 
 void ThemNhanVien(); 

}
